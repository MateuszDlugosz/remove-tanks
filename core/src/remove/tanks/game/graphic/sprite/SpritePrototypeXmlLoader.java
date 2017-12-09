package remove.tanks.game.graphic.sprite;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpritePrototypeXmlLoader {
    public static final String SPRITE_ELEMENT = "sprite";
    public static final String SPRITES_ELEMENT = "sprites";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<SpriteType, RegistrableSpritePrototypeXmlLoader> loaders
            = new EnumMap<>(SpriteType.class);

    public SpritePrototypeXmlLoader(RegistrableSpritePrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(s -> this.loaders.put(s.getLoaderType(), s));
    }

    public List<SpritePrototype> loadSpritePrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SPRITE_ELEMENT).toArray())
                .map(this::loadSpritePrototype)
                .collect(Collectors.toList());
    }

    public SpritePrototype loadSpritePrototype(XmlReader.Element element) {
        SpriteType type = SpriteType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!loaders.containsKey(type)) {
            throw new SpritePrototypeLoaderNotFoundException(type);
        }
        return loaders.get(type).loadSpritePrototype(element);
    }
}
