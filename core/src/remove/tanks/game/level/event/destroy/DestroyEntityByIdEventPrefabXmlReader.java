package remove.tanks.game.level.event.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEventPrefabXmlReader implements SubEventPrefabXmlReader<DestroyEntityByIdEventPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public DestroyEntityByIdEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new DestroyEntityByIdEventPrefab(readId(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public EventType getReaderType() {
        return EventType.DestroyEntityByIdEvent;
    }
}
