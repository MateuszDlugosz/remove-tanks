package remove.tanks.game.level.engine.listener.trigger;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class HitTriggerListenerPrefab extends AbstractTriggerListenerPrefab {
    public HitTriggerListenerPrefab(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
