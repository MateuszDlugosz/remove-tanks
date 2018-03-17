package remove.tanks.game.level.event.entity.points;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEntityEvent implements EntityEvent {
    private final Entity entity;

    public IncreasePointsMultiplierEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
