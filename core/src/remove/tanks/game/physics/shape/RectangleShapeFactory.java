package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class RectangleShapeFactory implements SubShapeFactory<PolygonShape, RectangleShapePrefab> {
    @Override
    public PolygonShape createShape(RectangleShapePrefab prefab, Scale scale) {
        try {
            PolygonShape shape = new PolygonShape();
            Vector2 position = new Vector2(
                    scale.scaleValue(prefab.getPositionPrefab().getX()),
                    scale.scaleValue(prefab.getPositionPrefab().getY())
            );
            shape.setAsBox(
                    scale.scaleValue(prefab.getWidth() * 0.5f),
                    scale.scaleValue(prefab.getHeight() * 0.5f),
                    position,
                    0
            );
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prefab, e);
        }
    }

    @Override
    public Class<RectangleShapePrefab> getFactoryType() {
        return RectangleShapePrefab.class;
    }
}
