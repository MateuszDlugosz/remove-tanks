package remove.tanks.game.level.engine.system.time;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;
import remove.tanks.game.level.engine.system.time.timeline.TimelinePrototype;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystemPrototype extends EntitySystemPrototype {
    private final TimelinePrototype timelinePrototype;

    public TimelineSystemPrototype(int priority, TimelinePrototype timelinePrototype) {
        super(priority);
        this.timelinePrototype = timelinePrototype;
    }

    public TimelinePrototype getTimelinePrototype() {
        return timelinePrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timelinePrototype", timelinePrototype)
                .toString();
    }
}
