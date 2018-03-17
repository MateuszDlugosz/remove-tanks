package remove.tanks.game.level.event.system;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEventPrefabXmlReader implements SubEventPrefabXmlReader<ActivateSystemEventPrefab> {
    private static final String CLASS_NAME_ELEMENT = "className";

    @Override
    public ActivateSystemEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new ActivateSystemEventPrefab(readClassName(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readClassName(XmlReader.Element element) {
        return element.getChildByName(CLASS_NAME_ELEMENT).getText().trim();
    }

    @Override
    public EventType getReaderType() {
        return EventType.ActivateSystemEvent;
    }
}
