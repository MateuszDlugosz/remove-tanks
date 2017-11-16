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
public final class ShapePrototypeXmlLoader {
    public static final String SHAPE_ELEMENT = "shape";
    public static final String SHAPES_ELEMENT = "shapes";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ShapeType, RegistrableShapePrototypeXmlLoader> subLoaders
            = new EnumMap<>(ShapeType.class);

    public ShapePrototypeXmlLoader(RegistrableShapePrototypeXmlLoader[] subLoaders) {
        Arrays.stream(subLoaders).forEach(l -> this.subLoaders.put(l.getLoaderType(), l));
    }

    public List<ShapePrototype> loadShapePrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SHAPE_ELEMENT).toArray())
                .map(this::loadShapePrototype)
                .collect(Collectors.toList());
    }

    public ShapePrototype loadShapePrototype(XmlReader.Element element) {
        ShapeType type = ShapeType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!subLoaders.containsKey(type)) {
            throw new ShapePrototypeLoaderNotFoundException(type);
        }
        return subLoaders.get(type).loadShapePrototype(element);
    }
}
