package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.color.ColorPrototype;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class ConeLightPrototype implements LightPrototype {
    private final ColorPrototype colorPrototype;
    private final PositionPrototype positionPrototype;
    private final float distance;
    private final float directionDegree;
    private final float coneDegree;
    private final boolean xRay;

    public ConeLightPrototype(
            ColorPrototype colorPrototype,
            PositionPrototype positionPrototype,
            float distance,
            float directionDegree,
            float coneDegree,
            boolean xRay
    ) {
        this.colorPrototype = colorPrototype;
        this.positionPrototype = positionPrototype;
        this.distance = distance;
        this.directionDegree = directionDegree;
        this.coneDegree = coneDegree;
        this.xRay = xRay;
    }

    @Override
    public ColorPrototype getColorPrototype() {
        return colorPrototype;
    }

    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
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
                .add("colorPrototype", colorPrototype)
                .add("positionPrototype", positionPrototype)
                .add("distance", distance)
                .add("directionDegree", directionDegree)
                .add("coneDegree", coneDegree)
                .add("xRay", xRay)
                .toString();
    }
}
