package remove.tanks.game.level.event.entity.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<ResetPointsMultiplierEntityEventPrefab> {
    @Override
    public ResetPointsMultiplierEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return ResetPointsMultiplierEntityEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.ResetPointsMultiplierEntityEvent;
    }
}
