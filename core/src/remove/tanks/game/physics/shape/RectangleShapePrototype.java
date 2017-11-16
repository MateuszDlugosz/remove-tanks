package remove.tanks.game.physics.shape;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class RectangleShapePrototype implements ShapePrototype {
    private final PositionPrototype positionPrototype;
    private final float width;
    private final float height;

    public RectangleShapePrototype(PositionPrototype positionPrototype, float width, float height) {
        this.positionPrototype = positionPrototype;
        this.width = width;
        this.height = height;
    }

    @Override
    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrototype", positionPrototype)
                .add("width", width)
                .add("height", height)
                .toString();
    }
}
