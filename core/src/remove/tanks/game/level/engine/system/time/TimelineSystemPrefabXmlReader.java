package remove.tanks.game.level.engine.system.time;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.utility.timeline.TimelinePrefab;
import remove.tanks.game.level.utility.timeline.TimelinePrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<TimelineSystemPrefab> {
    private final TimelinePrefabXmlReader timelinePrefabXmlReader;

    public TimelineSystemPrefabXmlReader(TimelinePrefabXmlReader timelinePrefabXmlReader) {
        this.timelinePrefabXmlReader = timelinePrefabXmlReader;
    }

    @Override
    public TimelineSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new TimelineSystemPrefab(priority, readTimelinePrefab(element));
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private TimelinePrefab readTimelinePrefab(XmlReader.Element element) {
        return timelinePrefabXmlReader.readTimelinePrefab(
                element.getChildByName(TimelinePrefabXmlReader.TIMELINE_ELEMENT));
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.TimelineSystem;
    }
}
