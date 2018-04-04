package remove.tanks.game.level.event.entity.message;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEntityEvent implements EntityEvent {
    private final Entity entity;

    public ClearMessagesEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
