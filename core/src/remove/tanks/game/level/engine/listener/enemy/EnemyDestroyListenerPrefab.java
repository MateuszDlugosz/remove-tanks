package remove.tanks.game.level.engine.listener.enemy;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrefab;
import remove.tanks.game.level.event.EventPrefab;

import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListenerPrefab extends EntityListenerPrefab {
    private final Map<Integer, List<EventPrefab>> eventThresholds;

    public EnemyDestroyListenerPrefab(int priority, Map<Integer, List<EventPrefab>> eventThresholds) {
        super(priority);
        this.eventThresholds = eventThresholds;
    }

    public Map<Integer, List<EventPrefab>> getEventThresholds() {
        return eventThresholds;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("eventThresholds", eventThresholds)
                .toString();
    }
}
