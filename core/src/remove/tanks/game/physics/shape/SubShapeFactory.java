package remove.tanks.game.physics.shape;

import com.badlogic.gdx.physics.box2d.Shape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface SubShapeFactory<T extends Shape, U extends ShapePrefab> {
    T createShape(U prefab, Scale scale);
    Class<U> getFactoryType();
}
