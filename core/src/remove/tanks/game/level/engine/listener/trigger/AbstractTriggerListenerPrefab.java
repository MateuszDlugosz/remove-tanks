package remove.tanks.game.level.engine.listener.trigger;

import remove.tanks.game.level.engine.listener.EntityListenerPrefab;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerListenerPrefab extends EntityListenerPrefab {
    public AbstractTriggerListenerPrefab(int priority) {
        super(priority);
    }

    @Override
    public abstract String toString();
}
