package remove.tanks.game.level.engine.system.time.timeline;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.time.timeline.entry.TimelineEntryPrototype;
import remove.tanks.game.level.engine.system.time.timeline.entry.TimelineEntryPrototypeXmlLoader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TimelinePrototypeXmlLoader {
    public static final String TIMELINE_ELEMENT = "timeline";

    private final TimelineEntryPrototypeXmlLoader timelineEntryPrototypeXmlLoader;

    public TimelinePrototypeXmlLoader(TimelineEntryPrototypeXmlLoader timelineEntryPrototypeXmlLoader) {
        this.timelineEntryPrototypeXmlLoader = timelineEntryPrototypeXmlLoader;
    }

    public TimelinePrototype loadTimelinePrototype(XmlReader.Element element) {
        try {
            return new TimelinePrototype(
                    loadTimelineEntryPrototypes(element)
            );
        } catch (Exception e) {
            throw new TimelinePrototypeXmlLoadException(element, e);
        }
    }

    private List<TimelineEntryPrototype> loadTimelineEntryPrototypes(XmlReader.Element element) {
        return timelineEntryPrototypeXmlLoader.loadTimelineEntryPrototypes(
                element.getChildByName(TimelineEntryPrototypeXmlLoader.TIMELINE_ENTRIES_ELEMENT)
        );
    }
}
