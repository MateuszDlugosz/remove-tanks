package remove.tanks.game.graphics.color;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ColorPrefabXmlReader {
    public static final String COLOR_ELEMENT = "color";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ColorType, SubColorPrefabXmlReader> readers
            = new EnumMap<>(ColorType.class);

    public ColorPrefabXmlReader(SubColorPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(r -> this.readers.put(r.getReaderType(), r));
    }

    public ColorPrefab readColorPrefab(XmlReader.Element element) {
        try {
            ColorType type = ColorType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new ColorPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readColorPrefab(element);
        } catch (Exception e) {
            throw new ColorPrefabXmlReadException(element, e);
        }
    }
}
