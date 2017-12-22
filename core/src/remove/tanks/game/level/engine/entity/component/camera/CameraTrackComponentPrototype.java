package remove.tanks.game.level.engine.entity.component.camera;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponentPrototype implements ComponentPrototype {
    private final PositionPrototype positionPrototype;
    private final int priority;

    public CameraTrackComponentPrototype(PositionPrototype positionPrototype, int priority) {
        this.positionPrototype = positionPrototype;
        this.priority = priority;
    }

    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrototype", positionPrototype)
                .add("priority", priority)
                .toString();
    }
}
