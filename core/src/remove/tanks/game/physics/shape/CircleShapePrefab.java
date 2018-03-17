package remove.tanks.game.physics.shape;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class CircleShapePrefab extends ShapePrefab {
    private final PositionPrefab positionPrefab;
    private final float radius;

    public CircleShapePrefab(PositionPrefab positionPrefab, float radius) {
        this.positionPrefab = positionPrefab;
        this.radius = radius;
    }

    @Override
    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrefab", positionPrefab)
                .add("radius", radius)
                .toString();
    }
}
