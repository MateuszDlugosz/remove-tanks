package remove.tanks.game.level.engine.entity.component.actor;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.utility.direction.Direction;

/**
 * @author Mateusz Długosz
 */
public final class ActorDirectionControllerComponentPrototype implements ComponentPrototype {
    private final Direction newDirection;

    public ActorDirectionControllerComponentPrototype(Direction newDirection) {
        this.newDirection = newDirection;
    }

    public Direction getNewDirection() {
        return newDirection;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("newDirection", newDirection)
                .toString();
    }
}
