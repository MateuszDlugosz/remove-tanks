package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEntityEvent implements EntityEvent {
    private final Entity entity;

    public ClearWeatherEffectsEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
