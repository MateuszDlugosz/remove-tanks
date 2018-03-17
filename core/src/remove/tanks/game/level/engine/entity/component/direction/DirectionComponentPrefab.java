package remove.tanks.game.level.engine.entity.component.direction;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.utility.direction.Direction;

/**
 * @author Mateusz Długosz
 */
public final class DirectionComponentPrefab extends ComponentPrefab {
    private final Direction direction;

    public DirectionComponentPrefab(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("direction", direction)
                .toString();
    }
}
