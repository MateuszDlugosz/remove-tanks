package remove.tanks.game.level.event.system;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DeactivateSystemEventPrefabXmlReader implements SubEventPrefabXmlReader<DeactivateSystemEventPrefab> {
    private static final String CLASS_NAME_ELEMENT = "className";

    @Override
    public DeactivateSystemEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new DeactivateSystemEventPrefab(readClassName(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readClassName(XmlReader.Element element) {
        return element.getChildByName(CLASS_NAME_ELEMENT).getText().trim();
    }

    @Override
    public EventType getReaderType() {
        return EventType.DeactivateSystemEvent;
    }
}
