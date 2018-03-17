package remove.tanks.game.level.event.life;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventPrefabXmlReader implements SubEventPrefabXmlReader<RemoveLifeEventPrefab> {
    @Override
    public RemoveLifeEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new RemoveLifeEventPrefab();
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EventType getReaderType() {
        return EventType.RemoveLifeEvent;
    }
}
