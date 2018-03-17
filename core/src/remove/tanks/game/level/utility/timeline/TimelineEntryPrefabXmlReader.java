package remove.tanks.game.level.utility.timeline;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.event.EventPrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryPrefabXmlReader {
    public static final String TIMELINE_ENTRY_ELEMENT = "timelineEntry";
    public static final String TIMELINE_ENTRIES_ELEMENT = "timelineEntries";

    private static final String TIME_ELEMENT = "time";

    private final EventPrefabXmlReader eventPrefabXmlReader;

    public TimelineEntryPrefabXmlReader(EventPrefabXmlReader eventPrefabXmlReader) {
        this.eventPrefabXmlReader = eventPrefabXmlReader;
    }

    public List<TimelineEntryPrefab> readTimelineEntryPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(TIMELINE_ENTRY_ELEMENT).toArray())
                .map(this::readTimelineEntryPrefab)
                .collect(Collectors.toList());
    }

    public TimelineEntryPrefab readTimelineEntryPrefab(XmlReader.Element element) {
        try {
            return new TimelineEntryPrefab(
                    readTime(element),
                    readEventPrefabs(element)
            );
        } catch (Exception e) {
            throw new TimelineEntryXmlReadException(element, e);
        }
    }

    private float readTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private List<EventPrefab> readEventPrefabs(XmlReader.Element element) {
        return eventPrefabXmlReader.readEventPrefabs(element.getChildByName(EventPrefabXmlReader.EVENTS_ELEMENT));
    }
}
