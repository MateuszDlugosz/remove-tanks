package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootComponent implements Component {
    public static final ComponentMapper<RandomShootComponent> MAPPER
            = ComponentMapper.getFor(RandomShootComponent.class);

    private final float minShootFrequency;
    private final float maxShootFrequency;
    private final Timer timer;

    public RandomShootComponent(float minShootFrequency, float maxShootFrequency, Timer timer) {
        this.minShootFrequency = minShootFrequency;
        this.maxShootFrequency = maxShootFrequency;
        this.timer = timer;
    }

    public float getMinShootFrequency() {
        return minShootFrequency;
    }

    public float getMaxShootFrequency() {
        return maxShootFrequency;
    }

    public Timer getTimer() {
        return timer;
    }
}
