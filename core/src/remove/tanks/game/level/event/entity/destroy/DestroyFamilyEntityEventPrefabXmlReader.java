package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<DestroyFamilyEntityEventPrefab> {
    private static final String ENTITY_FAMILY_ELEMENT = "entityFamily";

    @Override
    public DestroyFamilyEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new DestroyFamilyEntityEventPrefab(readEntityFamily(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private EntityFamily readEntityFamily(XmlReader.Element element) {
        return EntityFamily.valueOf(element.getChildByName(ENTITY_FAMILY_ELEMENT).getText().trim());
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.DestroyFamilyEntityEvent;
    }
}
