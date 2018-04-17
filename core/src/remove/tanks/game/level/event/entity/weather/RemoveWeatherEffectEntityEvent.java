package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class RemoveWeatherEffectEntityEvent implements EntityEvent {
    private final Entity entity;
    private final String id;

    public RemoveWeatherEffectEntityEvent(Entity entity, String id) {
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
