package remove.tanks.game.level.event.entity.message;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<ClearMessagesEntityEventPrefab> {
    @Override
    public ClearMessagesEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return ClearMessagesEntityEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.ClearMessagesEntityEvent;
    }
}
