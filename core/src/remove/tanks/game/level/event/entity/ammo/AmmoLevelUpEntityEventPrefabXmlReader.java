package remove.tanks.game.level.event.entity.ammo;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<AmmoLevelUpEntityEventPrefab> {
    @Override
    public AmmoLevelUpEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new AmmoLevelUpEntityEventPrefab();
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.AmmoLevelUpEntityEvent;
    }
}
