package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.utility.direction.Direction;

/**
 * @author Mateusz Długosz
 */
public final class DirectionComponent implements Component {
    public static final ComponentMapper<DirectionComponent> MAPPER
            = ComponentMapper.getFor(DirectionComponent.class);

    private final Direction direction;

    public DirectionComponent(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
