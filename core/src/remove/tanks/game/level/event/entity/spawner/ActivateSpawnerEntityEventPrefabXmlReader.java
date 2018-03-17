package remove.tanks.game.level.event.entity.spawner;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<ActivateSpawnerEntityEventPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public ActivateSpawnerEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new ActivateSpawnerEntityEventPrefab(readId(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.ActivateSpawnerEntityEvent;
    }
}
