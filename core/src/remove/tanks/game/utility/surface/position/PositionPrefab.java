package remove.tanks.game.utility.surface.position;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */

public final class PositionPrefab extends Prefab {
    public static final PositionPrefab POSITION_PREFAB_ZERO = new PositionPrefab(0f, 0f);

    private final float x;
    private final float y;

    public PositionPrefab(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("x", x)
                .add("y", y)
                .toString();
    }
}
