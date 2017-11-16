package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class CircleShapeFactory implements RegistrableShapeFactory<CircleShape, CircleShapePrototype> {
    @Override
    public CircleShape createShape(CircleShapePrototype prototype, Scale scale) {
        try {
            CircleShape shape = new CircleShape();
            shape.setRadius(scale.scaleValue(prototype.getRadius()));
            shape.setPosition(new Vector2(
                    scale.scaleValue(prototype.getPositionPrototype().getX()),
                    scale.scaleValue(prototype.getPositionPrototype().getY())
            ));
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prototype, e);
        }
    }

    @Override
    public Class<CircleShapePrototype> getFactoryType() {
        return CircleShapePrototype.class;
    }
}
