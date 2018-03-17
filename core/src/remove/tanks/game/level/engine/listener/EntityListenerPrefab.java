package remove.tanks.game.level.engine.listener;

import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public abstract class EntityListenerPrefab extends Prefab {
    private final int priority;

    public EntityListenerPrefab(int priority) {
        this.priority = priority;
    }

    public final int getPriority() {
        return priority;
    }
}
