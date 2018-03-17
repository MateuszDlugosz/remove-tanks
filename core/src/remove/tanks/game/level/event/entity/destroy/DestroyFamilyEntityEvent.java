package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEntityEvent implements EntityEvent {
    private final Entity entity;
    private final EntityFamily entityFamily;

    public DestroyFamilyEntityEvent(Entity entity, EntityFamily entityFamily) {
        this.entity = entity;
        this.entityFamily = entityFamily;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public EntityFamily getEntityFamily() {
        return entityFamily;
    }
}
