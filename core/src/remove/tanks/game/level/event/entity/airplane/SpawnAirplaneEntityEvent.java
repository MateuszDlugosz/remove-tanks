package remove.tanks.game.level.event.entity.airplane;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEntityEvent implements EntityEvent {
    private final Entity entity;

    public SpawnAirplaneEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
