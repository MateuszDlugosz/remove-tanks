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
public final class ShapeFactory {
    private final Map<Class<? extends ShapePrototype>, RegistrableShapeFactory> subFactories
            = new HashMap<>();

    public ShapeFactory(RegistrableShapeFactory[] subFactories) {
        for (RegistrableShapeFactory subFactory : subFactories) {
            this.subFactories.put(subFactory.getFactoryType(), subFactory);
        }
    }

    public List<Shape> createShapes(List<ShapePrototype> prototypes, Scale scale) {
        return prototypes.stream()
                .map(p -> createShape(p, scale))
                .collect(Collectors.toList());
    }

    public Shape createShape(ShapePrototype prototype, Scale scale) {
        Class<? extends ShapePrototype> prototypeClass = prototype.getClass();
        if (!subFactories.containsKey(prototypeClass)) {
            throw new ShapeFactoryNotFoundException(prototypeClass.toString());
        }
        return subFactories.get(prototypeClass).createShape(prototype, scale);
    }
}
