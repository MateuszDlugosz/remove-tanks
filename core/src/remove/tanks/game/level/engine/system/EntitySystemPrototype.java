package remove.tanks.game.level.engine.system;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public abstract class EntitySystemPrototype implements Serializable {
    private final int priority;

    public EntitySystemPrototype(int priority) {
        this.priority = priority;
    }

    public final int getPriority() {
        return priority;
    }

    @Override
    public abstract String toString();
}
