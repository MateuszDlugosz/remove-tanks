package remove.tanks.game.level.engine.entity.component.control;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlComponentPrototype implements ComponentPrototype {
    private final float shootDelay;

    public PlayerControlComponentPrototype(float shootDelay) {
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
