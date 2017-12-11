package remove.tanks.game.level.engine.system.time.timeline;

import remove.tanks.game.level.engine.system.time.timeline.entry.TimelineEntry;
import remove.tanks.game.level.engine.system.time.timeline.entry.TimelineEntryFactory;
import remove.tanks.game.level.engine.system.time.timeline.entry.TimelineEntryPrototype;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TimelineFactory {
    private final TimelineEntryFactory timelineEntryFactory;

    public TimelineFactory(TimelineEntryFactory timelineEntryFactory) {
        this.timelineEntryFactory = timelineEntryFactory;
    }

    public Timeline createTimeline(TimelinePrototype prototype) {
        try {
            return new Timeline(
                    createTimelineEntries(prototype.getTimelineEntryPrototypes())
            );
        } catch (Exception e) {
            throw new TimelineCreateException(e);
        }
    }

    private List<TimelineEntry> createTimelineEntries(List<TimelineEntryPrototype> prototypes) {
        return timelineEntryFactory.createTimelineEntries(prototypes).stream()
                .sorted(Comparator.comparing(TimelineEntry::getTime))
                .collect(Collectors.toList());
    }
}
