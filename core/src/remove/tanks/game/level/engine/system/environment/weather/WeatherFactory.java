package remove.tanks.game.level.engine.system.environment.weather;

import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffect;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectFactory;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototype;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class WeatherFactory {
    private final WeatherEffectFactory weatherEffectFactory;

    public WeatherFactory(WeatherEffectFactory weatherEffectFactory) {
        this.weatherEffectFactory = weatherEffectFactory;
    }

    public Weather createWeather(WeatherPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new Weather(
                    createWeatherEffects(prototype.getEffectPrototypes(), resourceRegistry)
            );
        } catch (Exception e) {
            throw new WeatherCreateException(prototype, e);
        }
    }

    private List<WeatherEffect> createWeatherEffects(List<WeatherEffectPrototype> prototypes, ResourceRegistry resourceRegistry) {
        return weatherEffectFactory.createWeatherEffects(prototypes, resourceRegistry);
    }
}
