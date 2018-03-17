package remove.tanks.game.physics.shape;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class VertexPrefab extends Prefab {
    private final float x;
    private final float y;

    public VertexPrefab(float x, float y) {
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
