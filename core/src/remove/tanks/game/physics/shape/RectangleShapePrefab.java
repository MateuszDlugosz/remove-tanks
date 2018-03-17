package remove.tanks.game.physics.shape;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RectangleShapePrefab extends ShapePrefab {
    private final PositionPrefab positionPrefab;
    private final float width;
    private final float height;

    public RectangleShapePrefab(PositionPrefab positionPrefab, float width, float height) {
        this.positionPrefab = positionPrefab;
        this.width = width;
        this.height = height;
    }

    @Override
    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrefab", positionPrefab)
                .add("width", width)
                .add("height", height)
                .toString();
    }
}
