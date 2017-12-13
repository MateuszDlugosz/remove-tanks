package remove.tanks.game.level.engine.system.environment.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototype;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffectPrototypeXmlLoader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class WeatherPrototypeXmlLoader {
    public static final String WEATHER_ELEMENT = "weather";

    private final WeatherEffectPrototypeXmlLoader weatherEffectPrototypeXmlLoader;

    public WeatherPrototypeXmlLoader(WeatherEffectPrototypeXmlLoader weatherEffectPrototypeXmlLoader) {
        this.weatherEffectPrototypeXmlLoader = weatherEffectPrototypeXmlLoader;
    }

    public WeatherPrototype loadWeatherPrototype(XmlReader.Element element) {
        try {
            return new WeatherPrototype(
                    loadWeatherEffectPrototypes(element)
            );
        } catch (Exception e) {
            throw new WeatherEffectPrototypeXmlLoadException(element, e);
        }
    }

    private List<WeatherEffectPrototype> loadWeatherEffectPrototypes(XmlReader.Element element) {
        return weatherEffectPrototypeXmlLoader.loadWeatherEffectPrototypes(
                element.getChildByName(WeatherEffectPrototypeXmlLoader.WEATHER_EFFECTS_ELEMENT)
        );
    }
}
