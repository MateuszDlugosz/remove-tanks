package remove.tanks.game.level.event.entity.points;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEntityEventPrefab extends EntityEventPrefab {
    private final int points;

    public AddPointsEntityEventPrefab(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("points", points)
                .toString();
    }
}
