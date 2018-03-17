package remove.tanks.game.level.event.entity.spawner;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEntityEvent implements EntityEvent {
    private final Entity entity;
    private final String id;

    public ActivateSpawnerEntityEvent(Entity entity, String id) {
        this.entity = entity;
        this.id = id;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public String getId() {
        return id;
    }
}
