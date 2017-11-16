package remove.tanks.game.level.engine.listener;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.Family;

/**
 * @author Mateusz Długosz
 */
public abstract class ExtendedEntityListener implements EntityListener {
    private final int priority;
    private final Family family;
    private final Engine engine;

    public ExtendedEntityListener(int priority, Family family, Engine engine) {
        this.priority = priority;
        this.family = family;
        this.engine = engine;
    }

    public int getPriority() {
        return priority;
    }

    public Family getFamily() {
        return family;
    }

    public Engine getEngine() {
        return engine;
    }
}
