package remove.tanks.game.level.engine.listener;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public abstract class EntityListenerPrototype implements Serializable {
    private final int priority;

    public EntityListenerPrototype(int priority) {
        this.priority = priority;
    }

    public final int getPriority() {
        return priority;
    }

    @Override
    public abstract String toString();
}
