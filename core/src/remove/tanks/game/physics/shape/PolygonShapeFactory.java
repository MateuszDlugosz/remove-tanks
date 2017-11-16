package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class PolygonShapeFactory implements RegistrableShapeFactory<PolygonShape, PolygonShapePrototype> {
    @Override
    public PolygonShape createShape(PolygonShapePrototype prototype, Scale scale) {
        try {
            PolygonShape shape = new PolygonShape();
            Vector2[] vertices = new Vector2[prototype.getVertexPrototypes().size()];
            int number = 0;
            for (VertexPrototype vertex : prototype.getVertexPrototypes()) {
                Vector2 vertexAsVector = new Vector2();
                vertexAsVector.x = scale.scaleValue(vertex.getX() + prototype.getPositionPrototype().getX());
                vertexAsVector.y = scale.scaleValue(vertex.getY() + prototype.getPositionPrototype().getY());
                vertices[number] = vertexAsVector;
                number++;
            }
            shape.set(vertices);
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prototype, e);
        }
    }

    @Override
    public Class<PolygonShapePrototype> getFactoryType() {
        return PolygonShapePrototype.class;
    }
}
