package remove.tanks.game.level.event.entity.points;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEntityEventPrefab extends EntityEventPrefab {
    public static final ResetPointsMultiplierEntityEventPrefab INSTANCE = new ResetPointsMultiplierEntityEventPrefab();

    private ResetPointsMultiplierEntityEventPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
