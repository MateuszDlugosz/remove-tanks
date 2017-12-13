package remove.tanks.game.level.engine.system.environment;

import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.system.environment.weather.Weather;
import remove.tanks.game.level.engine.system.environment.weather.WeatherFactory;
import remove.tanks.game.level.engine.system.environment.weather.WeatherPrototype;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemFactory
        implements RegistrableEntitySystemFactory<WeatherSystem, WeatherSystemPrototype>
{
    private final WeatherFactory weatherFactory;

    public WeatherSystemFactory(WeatherFactory weatherFactory) {
        this.weatherFactory = weatherFactory;
    }

    @Override
    public WeatherSystem createEntitySystem(WeatherSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new WeatherSystem(
                prototype.getPriority(),
                createWeather(prototype.getWeatherPrototype(), resourceRegistry)
        );
    }

    private Weather createWeather(WeatherPrototype prototype, ResourceRegistry resourceRegistry) {
        return weatherFactory.createWeather(prototype, resourceRegistry);
    }


    @Override
    public Class<WeatherSystemPrototype> getFactoryType() {
        return WeatherSystemPrototype.class;
    }
}
