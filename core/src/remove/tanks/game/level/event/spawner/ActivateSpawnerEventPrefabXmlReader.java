package remove.tanks.game.level.event.spawner;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEventPrefabXmlReader implements SubEventPrefabXmlReader<ActivateSpawnerEventPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public ActivateSpawnerEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new ActivateSpawnerEventPrefab(readId(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public EventType getReaderType() {
        return EventType.ActivateSpawnerEvent;
    }
}
