package remove.tanks.game.physics.shape;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.surface.position.PositionPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PolygonShapePrefab extends ShapePrefab {
    private final PositionPrefab positionPrefab;
    private final List<VertexPrefab> vertexPrefabs;

    public PolygonShapePrefab(PositionPrefab positionPrefab, List<VertexPrefab> vertexPrefabs) {
        this.positionPrefab = positionPrefab;
        this.vertexPrefabs = vertexPrefabs;
    }

    @Override
    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public List<VertexPrefab> getVertexPrefabs() {
        return vertexPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrefab", positionPrefab)
                .add("vertexPrefabs", vertexPrefabs)
                .toString();
    }
}
