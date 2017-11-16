package remove.tanks.game.level.engine.entity.component.direction;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.utility.direction.Direction;

/**
 * @author Mateusz Długosz
 */
public final class DirectionComponentPrototype implements ComponentPrototype {
    private final Direction direction;

    public DirectionComponentPrototype(Direction direction) {
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
