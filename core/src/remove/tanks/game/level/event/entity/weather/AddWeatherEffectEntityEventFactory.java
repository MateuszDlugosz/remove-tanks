package remove.tanks.game.level.event.entity.weather;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEntityEventFactory implements SubEntityEventFactory<AddWeatherEffectEntityEvent, AddWeatherEffectEntityEventPrefab> {
    private final WeatherEffectFactory weatherEffectFactory;

    public AddWeatherEffectEntityEventFactory(WeatherEffectFactory weatherEffectFactory) {
        this.weatherEffectFactory = weatherEffectFactory;
    }

    @Override
    public AddWeatherEffectEntityEvent createEntityEvent(AddWeatherEffectEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AddWeatherEffectEntityEvent(
                    entity,
                    createWeatherEffect(prefab.getWeatherEffectPrefab(), registry)
            );
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    private WeatherEffect createWeatherEffect(WeatherEffectPrefab prefab, ResourceRegistry registry) {
        return weatherEffectFactory.createWeatherEffect(prefab, registry);
    }

    @Override
    public Class<AddWeatherEffectEntityEventPrefab> getFactoryType() {
        return AddWeatherEffectEntityEventPrefab.class;
    }
}
