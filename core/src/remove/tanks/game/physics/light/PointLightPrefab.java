package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class PointLightPrefab extends LightPrefab {
    private final ColorPrefab colorPrefab;
    private final PositionPrefab positionPrefab;
    private final float distance;
    private final boolean xRay;

    public PointLightPrefab(
            ColorPrefab colorPrefab,
            PositionPrefab positionPrefab,
            float distance,
            boolean xRay
    ) {
        this.colorPrefab = colorPrefab;
        this.positionPrefab = positionPrefab;
        this.distance = distance;
        this.xRay = xRay;
    }

    @Override
    public ColorPrefab getColorPrefab() {
        return colorPrefab;
    }

    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public float getDistance() {
        return distance;
    }

    @Override
    public boolean getXRay() {
        return xRay;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("colorPrefab", colorPrefab)
                .add("positionPrefab", positionPrefab)
                .add("distance", distance)
                .add("xRay", xRay)
                .toString();
    }
}