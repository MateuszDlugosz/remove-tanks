package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEntityEventFactory implements SubEntityEventFactory<ClearWeatherEffectsEntityEvent, ClearWeatherEffectsEntityEventPrefab> {
    @Override
    public ClearWeatherEffectsEntityEvent createEntityEvent(ClearWeatherEffectsEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ClearWeatherEffectsEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ClearWeatherEffectsEntityEventPrefab> getFactoryType() {
        return ClearWeatherEffectsEntityEventPrefab.class;
    }
}
