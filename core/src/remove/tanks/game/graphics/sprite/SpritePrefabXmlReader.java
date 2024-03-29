package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class SpritePrefabXmlReader {
    public static final String SPRITE_ELEMENT = "sprite";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<SpriteType, SubSpritePrefabXmlReader> readers
            = new EnumMap<>(SpriteType.class);

    public SpritePrefabXmlReader(SubSpritePrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
    }

    public SpritePrefab readSpritePrefab(XmlReader.Element element) {
        try {
            SpriteType type = SpriteType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new SpritePrefabReaderNotFoundException(type);
            }
            return readers.get(type).readSpritePrefab(element);
        } catch (Exception e) {
            throw new SpritePrefabXmlReadException(element, e);
        }
    }
}
