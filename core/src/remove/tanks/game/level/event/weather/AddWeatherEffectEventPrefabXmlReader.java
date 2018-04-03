package remove.tanks.game.level.event.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEventPrefabXmlReader implements SubEventPrefabXmlReader<AddWeatherEffectEventPrefab> {
    private final WeatherEffectPrefabXmlReader weatherEffectPrefabXmlReader;

    public AddWeatherEffectEventPrefabXmlReader(WeatherEffectPrefabXmlReader weatherEffectPrefabXmlReader) {
        this.weatherEffectPrefabXmlReader = weatherEffectPrefabXmlReader;
    }

    @Override
    public AddWeatherEffectEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new AddWeatherEffectEventPrefab(
                    readWeatherEffectPrefab(element)
            );
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private WeatherEffectPrefab readWeatherEffectPrefab(XmlReader.Element element) {
        return weatherEffectPrefabXmlReader.readWeatherEffectPrefab(
                element.getChildByName(WeatherEffectPrefabXmlReader.WEATHER_EFFECT_ELEMENT)
        );
    }

    @Override
    public EventType getReaderType() {
        return EventType.AddWeatherEffectEvent;
    }
}
