package remove.tanks.game.level.event.entity.points;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEntityEvent implements EntityEvent {
    private final Entity entity;

    public ResetPointsMultiplierEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
