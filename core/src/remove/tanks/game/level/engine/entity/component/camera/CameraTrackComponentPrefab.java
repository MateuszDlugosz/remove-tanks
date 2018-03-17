package remove.tanks.game.level.engine.entity.component.camera;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponentPrefab extends ComponentPrefab {
    private final PositionPrefab positionPrefab;
    private final int priority;

    public CameraTrackComponentPrefab(PositionPrefab positionPrefab, int priority) {
        this.positionPrefab = positionPrefab;
        this.priority = priority;
    }

    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("positionPrefab", positionPrefab)
                .add("priority", priority)
                .toString();
    }
}
