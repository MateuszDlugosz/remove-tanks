package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LightPrototypeXmlLoader {
    public static final String LIGHT_ELEMENT = "light";
    public static final String LIGHTS_ELEMENT = "lights";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<LightType, RegistrableLightPrototypeXmlLoader> subLoaders
            = new EnumMap<>(LightType.class);

    public LightPrototypeXmlLoader(RegistrableLightPrototypeXmlLoader[] subLoaders) {
        Arrays.stream(subLoaders).forEach(s -> this.subLoaders.put(s.getLoaderType(), s));
    }

    public List<LightPrototype> loadLightPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(LIGHT_ELEMENT).toArray())
                .map(this::loadLightPrototype)
                .collect(Collectors.toList());
    }

    public LightPrototype loadLightPrototype(XmlReader.Element element) {
        LightType type = LightType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!subLoaders.containsKey(type)) {
            throw new LightPrototypeLoaderNotFoundException(type);
        }
        return subLoaders.get(type).loadLightPrototype(element);
    }
}
