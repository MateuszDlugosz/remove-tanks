package remove.tanks.game.level.engine.system.time;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;
import remove.tanks.game.level.utility.timeline.TimelinePrefab;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystemPrefab extends EntitySystemPrefab {
    private final TimelinePrefab timelinePrefab;

    public TimelineSystemPrefab(int priority, TimelinePrefab timelinePrefab) {
        super(priority);
        this.timelinePrefab = timelinePrefab;
    }

    public TimelinePrefab getTimelinePrefab() {
        return timelinePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timelinePrefab", timelinePrefab)
                .toString();
    }
}
