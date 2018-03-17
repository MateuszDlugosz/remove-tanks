package remove.tanks.game.level.engine.system.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.utility.weather.WeatherPrefab;
import remove.tanks.game.level.utility.weather.WeatherPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<WeatherSystemPrefab> {
    private final WeatherPrefabXmlReader weatherPrefabXmlReader;

    public WeatherSystemPrefabXmlReader(WeatherPrefabXmlReader weatherPrefabXmlReader) {
        this.weatherPrefabXmlReader = weatherPrefabXmlReader;
    }

    @Override
    public WeatherSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new WeatherSystemPrefab(
                    priority,
                    readWeatherPrefab(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private WeatherPrefab readWeatherPrefab(XmlReader.Element element) {
        return weatherPrefabXmlReader.readWeatherPrefab(
                element.getChildByName(WeatherPrefabXmlReader.WEATHER_ELEMENT)
        );
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.WeatherSystem;
    }
}
