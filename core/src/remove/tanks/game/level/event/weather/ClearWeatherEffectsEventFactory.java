package remove.tanks.game.level.event.weather;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEventFactory implements SubEventFactory<ClearWeatherEffectsEvent, ClearWeatherEffectsEventPrefab> {
    @Override
    public ClearWeatherEffectsEvent createEvent(ClearWeatherEffectsEventPrefab prefab, ResourceRegistry registry) {
        try {
            return ClearWeatherEffectsEvent.INSTANCE;
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ClearWeatherEffectsEventPrefab> getFactoryType() {
        return ClearWeatherEffectsEventPrefab.class;
    }
}
