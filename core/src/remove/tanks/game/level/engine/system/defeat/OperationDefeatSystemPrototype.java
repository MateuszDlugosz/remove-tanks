package remove.tanks.game.level.engine.system.defeat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;

/**
 * @author Mateusz Długosz
 */
public final class OperationDefeatSystemPrototype extends EntitySystemPrototype {
    private final float delay;

    public OperationDefeatSystemPrototype(int priority, float delay) {
        super(priority);
        this.delay = delay;
    }

    public float getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("delay", delay)
                .toString();
    }
}
