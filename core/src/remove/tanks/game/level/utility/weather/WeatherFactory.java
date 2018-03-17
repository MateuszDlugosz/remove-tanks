package remove.tanks.game.level.utility.weather;

import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectFactory;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class WeatherFactory {
    private final WeatherEffectFactory weatherEffectFactory;

    public WeatherFactory(WeatherEffectFactory weatherEffectFactory) {
        this.weatherEffectFactory = weatherEffectFactory;
    }

    public Weather createWeather(WeatherPrefab prefab, ResourceRegistry resourceRegistry) {
        try {
            return new Weather(createWeatherEffects(prefab.getEffectPrefabs(), resourceRegistry));
        } catch (Exception e) {
            throw new WeatherCreateException(prefab, e);
        }
    }

    private List<WeatherEffect> createWeatherEffects(List<WeatherEffectPrefab> prefabs, ResourceRegistry resourceRegistry) {
        return weatherEffectFactory.createWeatherEffects(prefabs, resourceRegistry);
    }
}
