package remove.tanks.game.level.engine.system.environment;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.system.environment.weather.WeatherPrototype;
import remove.tanks.game.level.engine.system.environment.weather.WeatherPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<WeatherSystemPrototype>
{
    private final WeatherPrototypeXmlLoader weatherPrototypeXmlLoader;

    public WeatherSystemPrototypeXmlLoader(WeatherPrototypeXmlLoader weatherPrototypeXmlLoader) {
        this.weatherPrototypeXmlLoader = weatherPrototypeXmlLoader;
    }

    @Override
    public WeatherSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new WeatherSystemPrototype(
                priority,
                loadWeatherPrototype(element)
        );
    }

    private WeatherPrototype loadWeatherPrototype(XmlReader.Element element) {
        return weatherPrototypeXmlLoader.loadWeatherPrototype(
                element.getChildByName(WeatherPrototypeXmlLoader.WEATHER_ELEMENT)
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.WeatherSystem;
    }
}
