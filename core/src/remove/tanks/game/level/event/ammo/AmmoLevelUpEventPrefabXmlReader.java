package remove.tanks.game.level.event.ammo;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEventPrefabXmlReader implements SubEventPrefabXmlReader<AmmoLevelUpEventPrefab> {
    @Override
    public AmmoLevelUpEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return AmmoLevelUpEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EventType getReaderType() {
        return EventType.AmmoLevelUpEvent;
    }
}
