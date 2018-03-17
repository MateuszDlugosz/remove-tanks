package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEvent implements EntityEvent {
    private final Entity entity;

    public DestroyEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
