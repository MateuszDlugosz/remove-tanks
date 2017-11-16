package remove.tanks.game.utility.position;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class PositionPrototype {
    private final float x;
    private final float y;

    public PositionPrototype(float x, float y) {
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
