package remove.tanks.game.level.engine.entity.component.direction;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.utility.direction.Direction;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponentPrototype implements ComponentPrototype {
    private final float changeDirectionMinFrequency;
    private final float changeDirectionMaxFrequency;
    private final List<Direction> availableDirections;

    public RandomDirectionComponentPrototype(
            float changeDirectionMinFrequency,
            float changeDirectionMaxFrequency,
            List<Direction> availableDirections
    ) {
        this.changeDirectionMinFrequency = changeDirectionMinFrequency;
        this.changeDirectionMaxFrequency = changeDirectionMaxFrequency;
        this.availableDirections = availableDirections;
    }

    public float getChangeDirectionMinFrequency() {
        return changeDirectionMinFrequency;
    }

    public float getChangeDirectionMaxFrequency() {
        return changeDirectionMaxFrequency;
    }

    public List<Direction> getAvailableDirections() {
        return availableDirections;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("changeDirectionMinFrequency", changeDirectionMinFrequency)
                .add("changeDirectionMaxFrequency", changeDirectionMaxFrequency)
                .add("availableDirections", availableDirections)
                .toString();
    }
}
