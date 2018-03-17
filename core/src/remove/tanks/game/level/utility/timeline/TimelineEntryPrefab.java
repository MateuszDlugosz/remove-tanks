package remove.tanks.game.level.utility.timeline;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryPrefab extends Prefab {
    private final float time;
    private final List<EventPrefab> eventPrefabs;

    public TimelineEntryPrefab(float time, List<EventPrefab> eventPrefabs) {
        this.time = time;
        this.eventPrefabs = eventPrefabs;
    }

    public float getTime() {
        return time;
    }

    public List<EventPrefab> getEventPrefabs() {
        return eventPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("eventPrefabs", eventPrefabs)
                .toString();
    }
}
