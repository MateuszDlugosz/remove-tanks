package remove.tanks.game.graphics.color;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class RgbaColorPrefab extends ColorPrefab {
    private final float r;
    private final float g;
    private final float b;
    private final float a;

    public RgbaColorPrefab(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
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

    public float getA() {
        return a;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("r", r)
                .add("g", g)
                .add("b", b)
                .add("a", a)
                .toString();
    }
}
