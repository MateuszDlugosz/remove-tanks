package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EffectPrototypeXmlLoader {
    public static final String EFFECT_ELEMENT = "effect";
    public static final String EFFECTS_ELEMENT = "effects";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<EffectType, RegistrableEffectPrototypeXmlLoader> loaders
            = new EnumMap<>(EffectType.class);

    public EffectPrototypeXmlLoader(RegistrableEffectPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(s -> this.loaders.put(s.getLoaderType(), s));
    }

    public List<EffectPrototype> loadEffectPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(EFFECT_ELEMENT).toArray())
                .map(this::loadEffectPrototype)
                .collect(Collectors.toList());
    }

    public EffectPrototype loadEffectPrototype(XmlReader.Element element) {
        EffectType type = EffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!loaders.containsKey(type)) {
            throw new EffectPrototypeLoaderNotFoundException(type);
        }
        return loaders.get(type).loadEffectPrototype(element);
    }
}
