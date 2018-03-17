package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<DestroyEntityEventPrefab> {
    @Override
    public DestroyEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new DestroyEntityEventPrefab();
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.DestroyEntityEvent;
    }
}
