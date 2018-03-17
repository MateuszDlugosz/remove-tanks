package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.color.ColorPrefab;

/**
 * @author Mateusz Długosz
 */
public final class DirectionalLightPrefab extends LightPrefab {
    private final ColorPrefab colorPrefab;
    private final float directionDegree;
    private final boolean xRay;

    public DirectionalLightPrefab(
            ColorPrefab colorPrefab,
            float directionDegree,
            boolean xRay
    ) {
        this.colorPrefab = colorPrefab;
        this.directionDegree = directionDegree;
        this.xRay = xRay;
    }

    @Override
    public ColorPrefab getColorPrefab() {
        return colorPrefab;
    }

    public float getDirectionDegree() {
        return directionDegree;
    }

    @Override
    public boolean getXRay() {
        return xRay;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("colorPrefab", colorPrefab)
                .add("directionDegree", directionDegree)
                .add("xRay", xRay)
                .toString();
    }
}
