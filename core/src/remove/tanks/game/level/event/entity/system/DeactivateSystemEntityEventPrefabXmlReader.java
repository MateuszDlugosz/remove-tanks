package remove.tanks.game.level.event.entity.system;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DeactivateSystemEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<DeactivateSystemEntityEventPrefab> {
    private static final String CLASS_NAME_ELEMENT = "className";

    @Override
    public DeactivateSystemEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new DeactivateSystemEntityEventPrefab(readClassName(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readClassName(XmlReader.Element element) {
        return element.getChildByName(CLASS_NAME_ELEMENT).getText().trim();
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.DeactivateSystemEntityEvent;
    }
}
