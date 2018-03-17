package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ShapePrefabXmlReader {
    public static final String SHAPE_ELEMENT = "shape";
    public static final String SHAPES_ELEMENT = "shapes";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ShapeType, SubShapePrefabXmlReader> readers
            = new EnumMap<>(ShapeType.class);

    public ShapePrefabXmlReader(SubShapePrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(l -> this.readers.put(l.getReaderType(), l));
    }

    public List<ShapePrefab> readShapePrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SHAPE_ELEMENT).toArray())
                .map(this::readShapePrefab)
                .collect(Collectors.toList());
    }

    public ShapePrefab readShapePrefab(XmlReader.Element element) {
        try {
            ShapeType type = ShapeType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new ShapePrefabReaderNotFoundException(type);
            }
            return readers.get(type).readShapePrefab(element);
        } catch (Exception e) {
            throw new ShapePrefabXmlReadException(element, e);
        }
    }
}
