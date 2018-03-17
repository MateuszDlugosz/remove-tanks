package remove.tanks.game.level.event.entity.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<AddPointsEntityEventPrefab> {
    private static final String POINTS_ELEMENT = "points";

    @Override
    public AddPointsEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new AddPointsEntityEventPrefab(readPoints(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private int readPoints(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(POINTS_ELEMENT).getText().trim());
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.AddPointsEntityEvent;
    }
}
