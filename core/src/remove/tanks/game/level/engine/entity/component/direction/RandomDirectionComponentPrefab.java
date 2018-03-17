package remove.tanks.game.level.engine.entity.component.direction;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.utility.direction.Direction;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponentPrefab extends ComponentPrefab {
    private final float minChangeDirectionFrequency;
    private final float maxChangeDirectionFrequency;
    private final List<Direction> directions;

    public RandomDirectionComponentPrefab(
            float minChangeDirectionFrequency,
            float maxChangeDirectionFrequency,
            List<Direction> directions
    ) {
        this.minChangeDirectionFrequency = minChangeDirectionFrequency;
        this.maxChangeDirectionFrequency = maxChangeDirectionFrequency;
        this.directions = directions;
    }

    public float getMinChangeDirectionFrequency() {
        return minChangeDirectionFrequency;
    }

    public float getMaxChangeDirectionFrequency() {
        return maxChangeDirectionFrequency;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("minChangeDirectionFrequency", minChangeDirectionFrequency)
                .add("maxChangeDirectionFrequency", maxChangeDirectionFrequency)
                .add("directions", directions)
                .toString();
    }
}
