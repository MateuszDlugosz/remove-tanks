package remove.tanks.game.physics.shape;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.position.PositionPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PolygonShapePrototype implements ShapePrototype {
    private final PositionPrototype positionPrototype;
    private final List<VertexPrototype> vertexPrototypes;

    public PolygonShapePrototype(PositionPrototype positionPrototype, List<VertexPrototype> vertexPrototypes) {
        this.positionPrototype = positionPrototype;
        this.vertexPrototypes = vertexPrototypes;
    }

    @Override
    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public List<VertexPrototype> getVertexPrototypes() {
        return vertexPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrototype", positionPrototype)
                .add("vertexPrototypes", vertexPrototypes)
                .toString();
    }
}
