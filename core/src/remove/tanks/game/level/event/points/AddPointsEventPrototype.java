package remove.tanks.game.level.event.points;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrototype;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventPrototype implements EventPrototype {
    private final int points;

    public AddPointsEventPrototype(int points) {
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
