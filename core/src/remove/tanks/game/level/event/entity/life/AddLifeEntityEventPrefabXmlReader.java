package remove.tanks.game.level.event.entity.life;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<AddLifeEntityEventPrefab> {
    @Override
    public AddLifeEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new AddLifeEntityEventPrefab();
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.AddLifeEntityEvent;
    }
}
