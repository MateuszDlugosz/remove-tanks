package remove.tanks.game.utility.surface.boundary;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class BoundaryPrefab extends Prefab {
    private final float minX;
    private final float maxX;
    private final float minY;
    private final float maxY;

    public BoundaryPrefab(float minX, float maxX, float minY, float maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public float getMinX() {
        return minX;
    }

    public float getMaxX() {
        return maxX;
    }

    public float getMinY() {
        return minY;
    }

    public float getMaxY() {
        return maxY;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("minX", minX)
                .add("maxX", maxX)
                .add("minY", minY)
                .add("maxY", maxY)
                .toString();
    }
}
