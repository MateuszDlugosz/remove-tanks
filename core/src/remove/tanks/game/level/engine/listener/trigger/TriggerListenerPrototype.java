package remove.tanks.game.level.engine.listener.trigger;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;

/**
 * @author Mateusz Długosz
 */
public final class TriggerListenerPrototype extends EntityListenerPrototype {
    public TriggerListenerPrototype(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
