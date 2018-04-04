package remove.tanks.game.level.event.entity.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefab;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<AddWeatherEffectEntityEventPrefab> {
    private final WeatherEffectPrefabXmlReader weatherEffectPrefabXmlReader;

    public AddWeatherEffectEntityEventPrefabXmlReader(WeatherEffectPrefabXmlReader weatherEffectPrefabXmlReader) {
        this.weatherEffectPrefabXmlReader = weatherEffectPrefabXmlReader;
    }

    @Override
    public AddWeatherEffectEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new AddWeatherEffectEntityEventPrefab(
                    readWeatherEffectPrefab(element)
            );
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private WeatherEffectPrefab readWeatherEffectPrefab(XmlReader.Element element) {
        return weatherEffectPrefabXmlReader.readWeatherEffectPrefab(
                element.getChildByName(WeatherEffectPrefabXmlReader.WEATHER_EFFECT_ELEMENT)
        );
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.AddWeatherEffectEntityEvent;
    }
}
