package remove.tanks.game.level.engine.system.weather;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.utility.weather.Weather;
import remove.tanks.game.level.utility.weather.WeatherFactory;
import remove.tanks.game.level.utility.weather.WeatherPrefab;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemFactory implements SubEntitySystemFactory<WeatherSystem, WeatherSystemPrefab> {
    private final WeatherFactory weatherFactory;

    public WeatherSystemFactory(WeatherFactory weatherFactory) {
        this.weatherFactory = weatherFactory;
    }

    @Override
    public WeatherSystem createEntitySystem(WeatherSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new WeatherSystem(
                    prefab.getPriority(),
                    createWeather(prefab.getWeatherPrefab(), registry)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Weather createWeather(WeatherPrefab prefab, ResourceRegistry registry) {
        return weatherFactory.createWeather(prefab, registry);
    }


    @Override
    public Class<WeatherSystemPrefab> getFactoryType() {
        return WeatherSystemPrefab.class;
    }
}
