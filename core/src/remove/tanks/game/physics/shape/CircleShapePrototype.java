package remove.tanks.game.physics.shape;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class CircleShapePrototype implements ShapePrototype {
    private final PositionPrototype positionPrototype;
    private final float radius;

    public CircleShapePrototype(PositionPrototype positionPrototype, float radius) {
        this.positionPrototype = positionPrototype;
        this.radius = radius;
    }

    @Override
    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrototype", positionPrototype)
                .add("radius", radius)
                .toString();
    }
}
