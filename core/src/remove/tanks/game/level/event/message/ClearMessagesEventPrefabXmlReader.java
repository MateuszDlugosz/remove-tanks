package remove.tanks.game.level.event.message;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEventPrefabXmlReader implements SubEventPrefabXmlReader<ClearMessagesEventPrefab> {
    @Override
    public ClearMessagesEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return ClearMessagesEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EventType getReaderType() {
        return EventType.ClearMessagesEvent;
    }
}
