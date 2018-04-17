package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class RemoveWeatherEffectEntityEventFactory implements SubEntityEventFactory<RemoveWeatherEffectEntityEvent, RemoveWeatherEffectEntityEventPrefab> {
    @Override
    public RemoveWeatherEffectEntityEvent createEntityEvent(RemoveWeatherEffectEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new RemoveWeatherEffectEntityEvent(entity, prefab.getId());
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<RemoveWeatherEffectEntityEventPrefab> getFactoryType() {
        return RemoveWeatherEffectEntityEventPrefab.class;
    }
}
