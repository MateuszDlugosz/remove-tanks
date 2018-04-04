package remove.tanks.game.level.event.entity.life;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEntityEvent implements EntityEvent {
    private final Entity entity;

    public RemoveLifeEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
