package remove.tanks.game.physics.shape;

import com.badlogic.gdx.physics.box2d.Shape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableShapeFactory<T extends Shape, U extends ShapePrototype> {
    T createShape(U prototype, Scale scale);
    Class<U> getFactoryType();
}
