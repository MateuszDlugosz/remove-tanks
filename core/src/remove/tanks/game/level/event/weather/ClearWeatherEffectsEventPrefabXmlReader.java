package remove.tanks.game.level.event.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEventPrefabXmlReader implements SubEventPrefabXmlReader<ClearWeatherEffectsEventPrefab> {
    @Override
    public ClearWeatherEffectsEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return ClearWeatherEffectsEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EventType getReaderType() {
        return EventType.ClearWeatherEffectsEvent;
    }
}
