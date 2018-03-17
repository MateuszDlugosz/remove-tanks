package remove.tanks.game.level.event.system;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class DeactivateSystemEvent implements Event {
    private final Class<? extends EntitySystem> systemClass;

    public DeactivateSystemEvent(Class<? extends EntitySystem> systemClass) {
        this.systemClass = systemClass;
    }

    public Class<? extends EntitySystem> getSystemClass() {
        return systemClass;
    }
}
