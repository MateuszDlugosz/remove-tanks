package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class CircleShapeFactory implements SubShapeFactory<CircleShape, CircleShapePrefab> {
    @Override
    public CircleShape createShape(CircleShapePrefab prefab, Scale scale) {
        try {
            CircleShape shape = new CircleShape();
            shape.setRadius(scale.scaleValue(prefab.getRadius()));
            shape.setPosition(new Vector2(
                    scale.scaleValue(prefab.getPositionPrefab().getX()),
                    scale.scaleValue(prefab.getPositionPrefab().getY())
            ));
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prefab, e);
        }
    }

    @Override
    public Class<CircleShapePrefab> getFactoryType() {
        return CircleShapePrefab.class;
    }
}
