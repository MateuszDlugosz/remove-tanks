package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpritePrefabXmlReader {
    public static final String SPRITE_ELEMENT = "sprite";
    public static final String SPRITES_ELEMENT = "sprites";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<SpriteType, SubSpritePrefabXmlReader> readers
            = new EnumMap<>(SpriteType.class);

    public SpritePrefabXmlReader(SubSpritePrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
    }

    public List<SpritePrefab> readSpritePrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SPRITE_ELEMENT).toArray())
                .map(this::readSpritePrefab)
                .collect(Collectors.toList());
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
