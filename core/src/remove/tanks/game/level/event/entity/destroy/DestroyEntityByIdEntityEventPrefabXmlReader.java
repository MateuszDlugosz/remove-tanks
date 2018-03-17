package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<DestroyEntityByIdEntityEventPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public DestroyEntityByIdEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new DestroyEntityByIdEntityEventPrefab(readId(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.DestroyEntityByIdEntityEvent;
    }
}
