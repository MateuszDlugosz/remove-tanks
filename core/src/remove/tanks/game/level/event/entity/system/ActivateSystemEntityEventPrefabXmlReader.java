package remove.tanks.game.level.event.entity.system;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.*;
import remove.tanks.game.level.event.system.ActivateSystemEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<ActivateSystemEntityEventPrefab> {
    private static final String CLASS_NAME_ELEMENT = "className";

    @Override
    public ActivateSystemEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new ActivateSystemEntityEventPrefab(readClassName(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private String readClassName(XmlReader.Element element) {
        return element.getChildByName(CLASS_NAME_ELEMENT).getText().trim();
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.ActivateSystemEntityEvent;
    }
}
