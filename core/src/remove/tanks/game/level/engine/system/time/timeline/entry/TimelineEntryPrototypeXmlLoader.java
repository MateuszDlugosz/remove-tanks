package remove.tanks.game.level.engine.system.time.timeline.entry;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrototype;
import remove.tanks.game.level.event.EventPrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryPrototypeXmlLoader {
    public static final String TIMELINE_ENTRY_ELEMENT = "timelineEntry";
    public static final String TIMELINE_ENTRIES_ELEMENT = "timelineEntries";

    private static final String TIME_ELEMENT = "time";

    private final EventPrototypeXmlLoader eventPrototypeXmlLoader;

    public TimelineEntryPrototypeXmlLoader(EventPrototypeXmlLoader eventPrototypeXmlLoader) {
        this.eventPrototypeXmlLoader = eventPrototypeXmlLoader;
    }

    public List<TimelineEntryPrototype> loadTimelineEntryPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(TIMELINE_ENTRY_ELEMENT).toArray())
                .map(this::loadTimelineEntryPrototype)
                .collect(Collectors.toList());
    }

    public TimelineEntryPrototype loadTimelineEntryPrototype(XmlReader.Element element) {
        try {
            return new TimelineEntryPrototype(
                    loadTime(element),
                    loadEventPrototypes(element)
            );
        } catch (Exception e) {
            throw new TimelineEntryPrototypeXmlLoadException(element, e);
        }
    }

    private float loadTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private List<EventPrototype> loadEventPrototypes(XmlReader.Element element) {
        return eventPrototypeXmlLoader.loadEventPrototypes(
                element.getChildByName(EventPrototypeXmlLoader.EVENTS_ELEMENT)
        );
    }
}
