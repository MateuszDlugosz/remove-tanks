package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ConeLightPrefab extends LightPrefab {
    private final ColorPrefab colorPrefab;
    private final PositionPrefab positionPrefab;
    private final float distance;
    private final float directionDegree;
    private final float coneDegree;
    private final boolean xRay;

    public ConeLightPrefab(
            ColorPrefab colorPrefab,
            PositionPrefab positionPrefab,
            float distance,
            float directionDegree,
            float coneDegree,
            boolean xRay
    ) {
        this.colorPrefab = colorPrefab;
        this.positionPrefab = positionPrefab;
        this.distance = distance;
        this.directionDegree = directionDegree;
        this.coneDegree = coneDegree;
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

    public float getDirectionDegree() {
        return directionDegree;
    }

    public float getConeDegree() {
        return coneDegree;
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
                .add("directionDegree", directionDegree)
                .add("coneDegree", coneDegree)
                .add("xRay", xRay)
                .toString();
    }
}
