package remove.tanks.game.level.event.points;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEventPrefab extends EventPrefab {
    public static final IncreasePointsMultiplierEventPrefab INSTANCE = new IncreasePointsMultiplierEventPrefab();

    private IncreasePointsMultiplierEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
