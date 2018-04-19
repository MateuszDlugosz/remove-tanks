package remove.tanks.game.level.event.entity.artillery;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<ArtilleryShootEntityEventPrefab> {
    @Override
    public ArtilleryShootEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return ArtilleryShootEntityEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.ArtilleryShootEntityEvent;
    }
}
