package remove.tanks.game.level.engine.system.time.timeline;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.time.timeline.entry.TimelineEntryPrototype;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TimelinePrototype implements Serializable {
    private final List<TimelineEntryPrototype> timelineEntryPrototypes;

    public TimelinePrototype(List<TimelineEntryPrototype> timelineEntryPrototypes) {
        this.timelineEntryPrototypes = timelineEntryPrototypes;
    }

    public List<TimelineEntryPrototype> getTimelineEntryPrototypes() {
        return timelineEntryPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timelineEntryPrototypes", timelineEntryPrototypes)
                .toString();
    }
}
