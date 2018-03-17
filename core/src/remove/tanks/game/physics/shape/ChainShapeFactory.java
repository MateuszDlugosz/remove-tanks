package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.ChainShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ChainShapeFactory implements SubShapeFactory<ChainShape, ChainShapePrefab> {
    @Override
    public ChainShape createShape(ChainShapePrefab prefab, Scale scale) {
        try {
            ChainShape shape = new ChainShape();
            Vector2[] vertices = new Vector2[prefab.getVertexPrefabs().size()];
            int number = 0;
            for (VertexPrefab vertex : prefab.getVertexPrefabs()) {
                Vector2 vertexAsVector = new Vector2();
                vertexAsVector.x = scale.scaleValue(vertex.getX() + prefab.getPositionPrefab().getX());
                vertexAsVector.y = scale.scaleValue(vertex.getY() + prefab.getPositionPrefab().getY());
                vertices[number] = vertexAsVector;
                number++;
            }
            shape.createChain(vertices);
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prefab, e);
        }
    }

    @Override
    public Class<ChainShapePrefab> getFactoryType() {
        return ChainShapePrefab.class;
    }
}
