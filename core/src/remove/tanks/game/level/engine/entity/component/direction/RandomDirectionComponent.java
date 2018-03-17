package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.utility.direction.Direction;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponent implements Component {
    public static final ComponentMapper<RandomDirectionComponent> MAPPER
            = ComponentMapper.getFor(RandomDirectionComponent.class);

    private final float minChangeDirectionFrequency;
    private final float maxChangeDirectionFrequency;
    private final List<Direction> directions;
    private final Timer timer;

    public RandomDirectionComponent(
            float minChangeDirectionFrequency,
            float maxChangeDirectionFrequency,
            List<Direction> directions,
            Timer timer
    ) {
        this.minChangeDirectionFrequency = minChangeDirectionFrequency;
        this.maxChangeDirectionFrequency = maxChangeDirectionFrequency;
        this.directions = directions;
        this.timer = timer;
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

    public Timer getTimer() {
        return timer;
    }
}
