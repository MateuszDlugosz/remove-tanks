package remove.tanks.game.level.engine.system.time.timeline.entry;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrototype;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryPrototype implements Serializable {
    private final float time;
    private final List<EventPrototype> eventPrototypes;

    public TimelineEntryPrototype(float time, List<EventPrototype> eventPrototypes) {
        this.time = time;
        this.eventPrototypes = eventPrototypes;
    }

    public float getTime() {
        return time;
    }

    public List<EventPrototype> getEventPrototypes() {
        return eventPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("eventPrototypes", eventPrototypes)
                .toString();
    }
}
