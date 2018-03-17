package remove.tanks.game.level.engine.entity.component.input;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class InputComponentPrefab extends ComponentPrefab {
    private final float shootDelay;

    public InputComponentPrefab(float shootDelay) {
        this.shootDelay = shootDelay;
    }

    public float getShootDelay() {
        return shootDelay;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("shootDelay", shootDelay)
                .toString();
    }
}
