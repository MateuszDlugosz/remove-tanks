package remove.tanks.game.level.engine.listener.trigger;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class CreateTriggerListenerPrefab extends AbstractTriggerListenerPrefab {
    public CreateTriggerListenerPrefab(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
