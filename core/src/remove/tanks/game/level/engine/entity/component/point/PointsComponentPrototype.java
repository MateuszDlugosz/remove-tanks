package remove.tanks.game.level.engine.entity.component.point;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class PointsComponentPrototype implements ComponentPrototype {
    private final int points;

    public PointsComponentPrototype(int points) {
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
