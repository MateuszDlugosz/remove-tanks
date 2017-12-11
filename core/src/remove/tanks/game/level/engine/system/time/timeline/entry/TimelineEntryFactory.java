package remove.tanks.game.level.engine.system.time.timeline.entry;

import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrototype;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryFactory {
    private final EventFactory eventFactory;

    public TimelineEntryFactory(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    public List<TimelineEntry> createTimelineEntries(List<TimelineEntryPrototype> prototypes) {
        return prototypes.stream()
                .map(this::createTimelineEntry)
                .collect(Collectors.toList());
    }

    public TimelineEntry createTimelineEntry(TimelineEntryPrototype prototype) {
        try {
            return new TimelineEntry(
                    prototype.getTime(),
                    createEvents(prototype.getEventPrototypes())
            );
        } catch (Exception e) {
            throw new TimelineEntryCreateException(e);
        }
    }

    private List<Event> createEvents(List<EventPrototype> prototypes) {
        return eventFactory.createEvents(prototypes);
    }
}
