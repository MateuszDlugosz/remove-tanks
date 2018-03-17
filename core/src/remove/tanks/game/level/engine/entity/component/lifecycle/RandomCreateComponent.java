package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateComponent implements Component {
    public static final ComponentMapper<RandomCreateComponent> MAPPER
            = ComponentMapper.getFor(RandomCreateComponent.class);

    private final float minCreateFrequency;
    private final float maxCreateFrequency;
    private final Timer timer;
    private final List<CreateEntry> createEntries;

    public RandomCreateComponent(
            float minCreateFrequency,
            float maxCreateFrequency,
            Timer timer,
            List<CreateEntry> createEntries
    ) {
        this.minCreateFrequency = minCreateFrequency;
        this.maxCreateFrequency = maxCreateFrequency;
        this.timer = timer;
        this.createEntries = createEntries;
    }

    public float getMinCreateFrequency() {
        return minCreateFrequency;
    }

    public float getMaxCreateFrequency() {
        return maxCreateFrequency;
    }

    public Timer getTimer() {
        return timer;
    }

    public List<CreateEntry> getCreateEntries() {
        return createEntries;
    }
}
