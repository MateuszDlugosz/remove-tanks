package remove.tanks.game.level.event.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventPrefabXmlReader implements SubEventPrefabXmlReader<AddPointsEventPrefab> {
    private static final String POINTS_ELEMENT = "points";

    @Override
    public AddPointsEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new AddPointsEventPrefab(readPoints(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private int readPoints(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(POINTS_ELEMENT).getText().trim());
    }

    @Override
    public EventType getReaderType() {
        return EventType.AddPointsEvent;
    }
}
