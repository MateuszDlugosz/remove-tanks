package remove.tanks.game.level.event.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RemoveWeatherEffectEventPrefabXmlReader implements SubEventPrefabXmlReader<RemoveWeatherEffectEventPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public RemoveWeatherEffectEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new RemoveWeatherEffectEventPrefab(readId(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public EventType getReaderType() {
        return EventType.RemoveWeatherEffectEvent;
    }
}
