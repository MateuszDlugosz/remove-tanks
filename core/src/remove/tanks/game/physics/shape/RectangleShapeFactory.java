package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class RectangleShapeFactory implements RegistrableShapeFactory<PolygonShape, RectangleShapePrototype> {
    @Override
    public PolygonShape createShape(RectangleShapePrototype prototype, Scale scale) {
        try {
            PolygonShape shape = new PolygonShape();
            Vector2 position = new Vector2(
                    scale.scaleValue(prototype.getPositionPrototype().getX()),
                    scale.scaleValue(prototype.getPositionPrototype().getY())
            );
            shape.setAsBox(
                    scale.scaleValue(prototype.getWidth() * 0.5f),
                    scale.scaleValue(prototype.getHeight() * 0.5f),
                    position,
                    0
            );
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prototype, e);
        }
    }

    @Override
    public Class<RectangleShapePrototype> getFactoryType() {
        return RectangleShapePrototype.class;
    }
}
