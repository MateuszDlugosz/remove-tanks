package remove.tanks.game.level.event.weather;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEventFactory implements SubEventFactory<AddWeatherEffectEvent, AddWeatherEffectEventPrefab> {
    private final WeatherEffectFactory weatherEffectFactory;

    public AddWeatherEffectEventFactory(WeatherEffectFactory weatherEffectFactory) {
        this.weatherEffectFactory = weatherEffectFactory;
    }

    @Override
    public AddWeatherEffectEvent createEvent(AddWeatherEffectEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new AddWeatherEffectEvent(
                    createWeatherEffect(prefab.getWeatherEffectPrefab(), registry)
            );
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    private WeatherEffect createWeatherEffect(WeatherEffectPrefab prefab, ResourceRegistry registry) {
        return weatherEffectFactory.createWeatherEffect(prefab, registry);
    }

    @Override
    public Class<AddWeatherEffectEventPrefab> getFactoryType() {
        return AddWeatherEffectEventPrefab.class;
    }
}
