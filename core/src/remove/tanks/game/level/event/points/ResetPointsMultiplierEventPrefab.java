package remove.tanks.game.level.event.points;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEventPrefab extends EventPrefab {
    public static final ResetPointsMultiplierEventPrefab INSTANCE = new ResetPointsMultiplierEventPrefab();

    private ResetPointsMultiplierEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
