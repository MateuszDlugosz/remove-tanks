package remove.tanks.game.level.event.weather;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class RemoveWeatherEffectEventFactory implements SubEventFactory<RemoveWeatherEffectEvent, RemoveWeatherEffectEventPrefab> {
    @Override
    public RemoveWeatherEffectEvent createEvent(RemoveWeatherEffectEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new RemoveWeatherEffectEvent(prefab.getId());
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<RemoveWeatherEffectEventPrefab> getFactoryType() {
        return RemoveWeatherEffectEventPrefab.class;
    }
}
