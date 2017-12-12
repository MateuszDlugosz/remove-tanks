package remove.tanks.game.level.engine.system.environment.weather.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableWeatherEffectPrototypeXmlLoader<T extends WeatherEffectPrototype> {
    T loadWeatherEffect(XmlReader.Element element);
    WeatherEffectType getLoaderType();
}
