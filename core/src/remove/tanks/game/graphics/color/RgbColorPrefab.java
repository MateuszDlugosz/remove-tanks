package remove.tanks.game.graphics.color;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class RgbColorPrefab extends ColorPrefab {
    public static final RgbColorPrefab WHITE = new RgbColorPrefab(255f, 255f, 255f);

    private final float r;
    private final float g;
    private final float b;

    public RgbColorPrefab(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public float getR() {
        return r;
    }

    public float getG() {
        return g;
    }

    public float getB() {
        return b;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("r", r)
                .add("g", g)
                .add("b", b)
                .toString();
    }
}
