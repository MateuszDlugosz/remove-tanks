package remove.tanks.game.level.event.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEventPrefabXmlReader implements SubEventPrefabXmlReader<DestroyFamilyEventPrefab> {
    private static final String ENTITY_FAMILY_ELEMENT = "entityFamily";

    @Override
    public DestroyFamilyEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new DestroyFamilyEventPrefab(readEntityFamily(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private EntityFamily readEntityFamily(XmlReader.Element element) {
        return EntityFamily.valueOf(element.getChildByName(ENTITY_FAMILY_ELEMENT).getText().trim());
    }

    @Override
    public EventType getReaderType() {
        return EventType.DestroyFamilyEvent;
    }
}
