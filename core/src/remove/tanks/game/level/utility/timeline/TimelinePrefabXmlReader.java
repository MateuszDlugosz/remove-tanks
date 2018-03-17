package remove.tanks.game.level.utility.timeline;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TimelinePrefabXmlReader {
    public static final String TIMELINE_ELEMENT = "timeline";
    public static final String TIMELINES_ELEMENT = "timelines";

    private final TimelineEntryPrefabXmlReader timelineEntryPrefabXmlReader;

    public TimelinePrefabXmlReader(TimelineEntryPrefabXmlReader timelineEntryPrefabXmlReader) {
        this.timelineEntryPrefabXmlReader = timelineEntryPrefabXmlReader;
    }

    public List<TimelinePrefab> readTimelinePrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(TIMELINE_ELEMENT).toArray())
                .map(this::readTimelinePrefab)
                .collect(Collectors.toList());
    }

    public TimelinePrefab readTimelinePrefab(XmlReader.Element element) {
        try {
            return new TimelinePrefab(readTimelineEntryPrefabs(element));
        } catch (Exception e) {
            throw new TimelinePrefabXmlReadException(element, e);
        }
    }

    private List<TimelineEntryPrefab> readTimelineEntryPrefabs(XmlReader.Element element) {
        return timelineEntryPrefabXmlReader.readTimelineEntryPrefabs(
                element.getChildByName(TimelineEntryPrefabXmlReader.TIMELINE_ENTRIES_ELEMENT)
        );
    }
}
