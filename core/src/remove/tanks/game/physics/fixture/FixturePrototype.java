package remove.tanks.game.physics.fixture;

import com.google.common.base.MoreObjects;
import remove.tanks.game.physics.filter.FilterPrototype;
import remove.tanks.game.physics.shape.ShapePrototype;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class FixturePrototype implements Serializable {
    private final FilterPrototype filterPrototype;
    private final ShapePrototype shapePrototype;
    private final float restitution;
    private final float density;
    private final float friction;
    private final boolean isSensor;

    public FixturePrototype(
            FilterPrototype filterPrototype,
            ShapePrototype shapePrototype,
            float restitution,
            float density,
            float friction,
            boolean isSensor
    ) {
        this.filterPrototype = filterPrototype;
        this.shapePrototype = shapePrototype;
        this.restitution = restitution;
        this.density = density;
        this.friction = friction;
        this.isSensor = isSensor;
    }

    public FilterPrototype getFilterPrototype() {
        return filterPrototype;
    }

    public ShapePrototype getShapePrototype() {
        return shapePrototype;
    }

    public float getRestitution() {
        return restitution;
    }

    public float getDensity() {
        return density;
    }

    public float getFriction() {
        return friction;
    }

    public boolean isSensor() {
        return isSensor;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filterPrototype", filterPrototype)
                .add("shapePrototype", shapePrototype)
                .add("restitution", restitution)
                .add("density", density)
                .add("friction", friction)
                .add("isSensor", isSensor)
                .toString();
    }
}
