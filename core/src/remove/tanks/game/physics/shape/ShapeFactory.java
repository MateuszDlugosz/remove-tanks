package remove.tanks.game.physics.shape;

import com.badlogic.gdx.physics.box2d.Shape;
import remove.tanks.game.utility.scale.Scale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ShapeFactory {
    private final Map<Class<? extends ShapePrototype>, RegistrableShapeFactory> factories
            = new HashMap<>();

    public ShapeFactory(RegistrableShapeFactory[] factories) {
        for (RegistrableShapeFactory subFactory : factories) {
            this.factories.put(subFactory.getFactoryType(), subFactory);
        }
    }

    public List<Shape> createShapes(List<ShapePrototype> prototypes, Scale scale) {
        return prototypes.stream()
                .map(p -> createShape(p, scale))
                .collect(Collectors.toList());
    }

    public Shape createShape(ShapePrototype prototype, Scale scale) {
        try {
            Class<? extends ShapePrototype> prototypeClass = prototype.getClass();
            if (!factories.containsKey(prototypeClass)) {
                throw new ShapeFactoryNotFoundException(prototypeClass.toString());
            }
            return factories.get(prototypeClass).createShape(prototype, scale);
        } catch (Exception e) {
            throw new ShapeCreateException(prototype, e);
        }
    }
}
