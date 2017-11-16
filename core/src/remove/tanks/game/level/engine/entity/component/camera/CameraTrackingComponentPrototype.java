package remove.tanks.game.level.engine.entity.component.camera;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackingComponentPrototype implements ComponentPrototype {
    private final PositionPrototype positionPrototype;

    public CameraTrackingComponentPrototype(PositionPrototype positionPrototype) {
        this.positionPrototype = positionPrototype;
    }

    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrototype", positionPrototype)
                .toString();
    }
}
