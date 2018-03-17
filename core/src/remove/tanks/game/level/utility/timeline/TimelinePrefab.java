package remove.tanks.game.level.utility.timeline;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TimelinePrefab extends Prefab {
    private final List<TimelineEntryPrefab> timelineEntryPrefabs;

    public TimelinePrefab(List<TimelineEntryPrefab> timelineEntryPrefabs) {
        this.timelineEntryPrefabs = timelineEntryPrefabs;
    }

    public List<TimelineEntryPrefab> getTimelineEntryPrefabs() {
        return timelineEntryPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timelineEntryPrefabs", timelineEntryPrefabs)
                .toString();
    }
}
