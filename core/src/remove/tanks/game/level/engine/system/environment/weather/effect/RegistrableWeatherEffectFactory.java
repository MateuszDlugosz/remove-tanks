package remove.tanks.game.level.engine.system.environment.weather.effect;

import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableWeatherEffectFactory<T extends WeatherEffect, U extends WeatherEffectPrototype> {
    T createWeatherEffect(U prototype, ResourceRegistry resourceRegistry);
    Class<U> getFactoryType();
}
