package remove.tanks.game.level.engine.entity.component.actor;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.utility.direction.Direction;

/**
 * @author Mateusz Długosz
 */
public final class ActorDirectionControllerComponent implements Component {
    public static final ComponentMapper<ActorDirectionControllerComponent> MAPPER
            = ComponentMapper.getFor(ActorDirectionControllerComponent.class);

    private final Direction newDirection;

    public ActorDirectionControllerComponent(Direction newDirection) {
        this.newDirection = newDirection;
    }

    public Direction getNewDirection() {
        return newDirection;
    }
}
