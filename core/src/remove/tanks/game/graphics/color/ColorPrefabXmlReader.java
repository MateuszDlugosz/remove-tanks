package remove.tanks.game.graphics.color;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ColorPrefabXmlReader {
    public static final String COLOR_ELEMENT = "color";
    public static final String COLORS_ELEMENT = "colors";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ColorType, SubColorPrefabXmlReader> readers
            = new EnumMap<>(ColorType.class);

    public ColorPrefabXmlReader(SubColorPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(r -> this.readers.put(r.getReaderType(), r));
    }

    public List<ColorPrefab> readColorPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(COLOR_ELEMENT).toArray())
                .map(this::readColorPrefab)
                .collect(Collectors.toList());
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
