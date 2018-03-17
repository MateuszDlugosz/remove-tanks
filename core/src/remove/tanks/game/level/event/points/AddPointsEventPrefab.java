package remove.tanks.game.level.event.points;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventPrefab extends EventPrefab {
    private final int points;

    public AddPointsEventPrefab(int points) {
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
