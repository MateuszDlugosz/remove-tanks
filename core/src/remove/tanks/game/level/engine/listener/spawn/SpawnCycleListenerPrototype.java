package remove.tanks.game.level.engine.listener.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;

/**
 * @author Mateusz Długosz
 */
public final class SpawnCycleListenerPrototype extends EntityListenerPrototype {
    public SpawnCycleListenerPrototype(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
