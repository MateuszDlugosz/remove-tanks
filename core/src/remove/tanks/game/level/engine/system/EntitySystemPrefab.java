package remove.tanks.game.level.engine.system;

import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public abstract class EntitySystemPrefab extends Prefab {
    private final int priority;

    public EntitySystemPrefab(int priority) {
        this.priority = priority;
    }

    public final int getPriority() {
        return priority;
    }

    @Override
    public abstract String toString();
}
