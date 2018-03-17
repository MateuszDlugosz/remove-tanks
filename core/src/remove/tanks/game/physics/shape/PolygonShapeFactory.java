package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class PolygonShapeFactory implements SubShapeFactory<PolygonShape, PolygonShapePrefab> {
    @Override
    public PolygonShape createShape(PolygonShapePrefab prefab, Scale scale) {
        try {
            PolygonShape shape = new PolygonShape();
            Vector2[] vertices = new Vector2[prefab.getVertexPrefabs().size()];
            int number = 0;
            for (VertexPrefab vertex : prefab.getVertexPrefabs()) {
                Vector2 vertexAsVector = new Vector2();
                vertexAsVector.x = scale.scaleValue(vertex.getX() + prefab.getPositionPrefab().getX());
                vertexAsVector.y = scale.scaleValue(vertex.getY() + prefab.getPositionPrefab().getY());
                vertices[number] = vertexAsVector;
                number++;
            }
            shape.set(vertices);
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prefab, e);
        }
    }

    @Override
    public Class<PolygonShapePrefab> getFactoryType() {
        return PolygonShapePrefab.class;
    }
}
