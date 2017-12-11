package remove.tanks.game.level.engine.system.time.timeline;

import remove.tanks.game.level.engine.system.time.timeline.entry.TimelineEntry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Timeline {
    private final List<TimelineEntry> timelineEntries;

    public Timeline(List<TimelineEntry> timelineEntries) {
        this.timelineEntries = timelineEntries;
    }

    public List<TimelineEntry> getTimelineEntries() {
        return timelineEntries;
    }
}
