package remove.tanks.game.level.event.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEventPrefabXmlReader implements SubEventPrefabXmlReader<IncreasePointsMultiplierEventPrefab> {
    @Override
    public IncreasePointsMultiplierEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new IncreasePointsMultiplierEventPrefab();
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EventType getReaderType() {
        return EventType.IncreasePointsMultiplierEvent;
    }
}
