package remove.tanks.game.level.event.system;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEvent implements Event {
    private final Class<? extends EntitySystem> systemClass;

    public ActivateSystemEvent(Class<? extends EntitySystem> systemClass) {
        this.systemClass = systemClass;
    }

    public Class<? extends EntitySystem> getSystemClass() {
        return systemClass;
    }
}
