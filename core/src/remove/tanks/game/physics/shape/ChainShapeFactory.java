package remove.tanks.game.physics.shape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.ChainShape;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ChainShapeFactory implements RegistrableShapeFactory<ChainShape, ChainShapePrototype> {
    @Override
    public ChainShape createShape(ChainShapePrototype prototype, Scale scale) {
        try {
            ChainShape shape = new ChainShape();
            Vector2[] vertices = new Vector2[prototype.getVertexPrototypes().size()];
            int number = 0;
            for (VertexPrototype vertex : prototype.getVertexPrototypes()) {
                Vector2 vertexAsVector = new Vector2();
                vertexAsVector.x = scale.scaleValue(vertex.getX() + prototype.getPositionPrototype().getX());
                vertexAsVector.y = scale.scaleValue(vertex.getY() + prototype.getPositionPrototype().getY());
                vertices[number] = vertexAsVector;
                number++;
            }
            shape.createChain(vertices);
            return shape;
        } catch (Exception e) {
            throw new ShapeCreateException(prototype, e);
        }
    }

    @Override
    public Class<ChainShapePrototype> getFactoryType() {
        return ChainShapePrototype.class;
    }
}
