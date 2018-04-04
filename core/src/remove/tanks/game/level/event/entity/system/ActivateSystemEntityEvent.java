package remove.tanks.game.level.event.entity.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEntityEvent implements EntityEvent {
    private final Entity entity;
    private final Class<? extends EntitySystem> systemClass;

    public ActivateSystemEntityEvent(Entity entity, Class<? extends EntitySystem> systemClass) {
        this.entity = entity;
        this.systemClass = systemClass;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public Class<? extends EntitySystem> getSystemClass() {
        return systemClass;
    }
}
