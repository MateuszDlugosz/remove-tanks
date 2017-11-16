package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.color.ColorPrototype;

/**
 * @author Mateusz Długosz
 */
public final class DirectionalLightPrototype implements LightPrototype {
    private final ColorPrototype colorPrototype;
    private final float directionDegree;
    private final boolean xRay;

    public DirectionalLightPrototype(
            ColorPrototype colorPrototype,
            float directionDegree,
            boolean xRay
    ) {
        this.colorPrototype = colorPrototype;
        this.directionDegree = directionDegree;
        this.xRay = xRay;
    }

    @Override
    public ColorPrototype getColorPrototype() {
        return colorPrototype;
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
                .add("colorPrototype", colorPrototype)
                .add("directionDegree", directionDegree)
                .add("xRay", xRay)
                .toString();
    }
}
