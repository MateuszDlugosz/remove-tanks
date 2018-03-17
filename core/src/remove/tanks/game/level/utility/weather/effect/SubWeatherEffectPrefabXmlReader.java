package remove.tanks.game.level.utility.weather.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubWeatherEffectPrefabXmlReader<T extends WeatherEffectPrefab> {
    T readWeatherEffect(XmlReader.Element element);
    WeatherEffectType getReaderType();
}
