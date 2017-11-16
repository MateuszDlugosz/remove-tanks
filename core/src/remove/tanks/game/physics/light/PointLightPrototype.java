package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.color.ColorPrototype;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class PointLightPrototype implements LightPrototype {
    private final ColorPrototype colorPrototype;
    private final PositionPrototype positionPrototype;
    private final float distance;
    private final boolean xRay;

    public PointLightPrototype(
            ColorPrototype colorPrototype,
            PositionPrototype positionPrototype,
            float distance,
            boolean xRay
    ) {
        this.colorPrototype = colorPrototype;
        this.positionPrototype = positionPrototype;
        this.distance = distance;
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
                .add("xRay", xRay)
                .toString();
    }
}
