package remove.tanks.game.physics.shape;

import com.badlogic.gdx.physics.box2d.Shape;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ShapeFactory {
    private final Map<Class<? extends ShapePrefab>, SubShapeFactory> factories
            = new HashMap<>();

    public ShapeFactory(SubShapeFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public Shape createShape(ShapePrefab prefab, Scale scale) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new ShapeFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createShape(prefab, scale);
        } catch (Exception e) {
            throw new ShapeCreateException(prefab, e);
        }
    }
}
