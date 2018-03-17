package remove.tanks.game.level.utility.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class WeatherPrefabXmlReader {
    public static final String WEATHER_ELEMENT = "weather";

    private final WeatherEffectPrefabXmlReader weatherEffectPrefabXmlReader;

    public WeatherPrefabXmlReader(WeatherEffectPrefabXmlReader weatherEffectPrefabXmlReader) {
        this.weatherEffectPrefabXmlReader = weatherEffectPrefabXmlReader;
    }

    private List<WeatherEffectPrefab> readWeatherEffectPrefabs(XmlReader.Element element) {
        return weatherEffectPrefabXmlReader.readWeatherEffectPrefabs(
                element.getChildByName(WeatherEffectPrefabXmlReader.WEATHER_EFFECTS_ELEMENT)
        );
    }

    public WeatherPrefab readWeatherPrefab(XmlReader.Element element) {
        try {
            return new WeatherPrefab(readWeatherEffectPrefabs(element));
        } catch (Exception e) {
            throw new WeatherPrefabXmlReadException(element, e);
        }
    }
}
