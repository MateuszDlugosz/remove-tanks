package remove.tanks.game.level.event.entity.artillery;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEntityEvent implements EntityEvent {
    private final Entity entity;

    public ArtilleryShootEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
