package remove.tanks.game.level.event.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEventPrefabXmlReader implements SubEventPrefabXmlReader<ResetPointsMultiplierEventPrefab> {
    @Override
    public ResetPointsMultiplierEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return ResetPointsMultiplierEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EventType getReaderType() {
        return EventType.ResetPointsMultiplierEvent;
    }
}
