package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.utility.direction.Direction;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponent implements Component {
    public static final ComponentMapper<RandomDirectionComponent> MAPPER
            = ComponentMapper.getFor(RandomDirectionComponent.class);

    private final float changeDirectionMinFrequency;
    private final float changeDirectionMaxFrequency;
    private final List<Direction> availableDirections;
    private final Timer timer;

    public RandomDirectionComponent(
            float changeDirectionMinFrequency,
            float changeDirectionMaxFrequency,
            List<Direction> availableDirections,
            Timer timer
    ) {
        this.changeDirectionMinFrequency = changeDirectionMinFrequency;
        this.changeDirectionMaxFrequency = changeDirectionMaxFrequency;
        this.availableDirections = availableDirections;
        this.timer = timer;
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

    public Timer getTimer() {
        return timer;
    }
}
