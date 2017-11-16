package remove.tanks.game.utility.boundary;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class BoundariesPrototype implements Serializable {
    private final float minX;
    private final float maxX;
    private final float minY;
    private final float maxY;

    public BoundariesPrototype(float minX, float maxX, float minY, float maxY) {
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
