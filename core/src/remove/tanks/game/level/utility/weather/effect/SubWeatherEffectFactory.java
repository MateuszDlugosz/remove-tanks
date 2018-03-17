package remove.tanks.game.level.utility.weather.effect;

import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubWeatherEffectFactory<T extends WeatherEffect, U extends WeatherEffectPrefab> {
    T createWeatherEffect(U prefab, ResourceRegistry registry);
    Class<U> getFactoryType();
}
