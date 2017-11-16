package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntry;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnComponent implements Component {
    public static final ComponentMapper<RandomSpawnComponent> MAPPER
            = ComponentMapper.getFor(RandomSpawnComponent.class);

    private final float minSpawnFrequency;
    private final float maxSpawnFrequency;
    private final Timer timer;
    private final List<SpawnEntry> spawnEntries;

    public RandomSpawnComponent(
            float minSpawnFrequency,
            float maxSpawnFrequency,
            Timer timer,
            List<SpawnEntry> spawnEntries
    ) {
        this.minSpawnFrequency = minSpawnFrequency;
        this.maxSpawnFrequency = maxSpawnFrequency;
        this.timer = timer;
        this.spawnEntries = spawnEntries;
    }

    public float getMinSpawnFrequency() {
        return minSpawnFrequency;
    }

    public float getMaxSpawnFrequency() {
        return maxSpawnFrequency;
    }

    public Timer getTimer() {
        return timer;
    }

    public List<SpawnEntry> getSpawnEntries() {
        return spawnEntries;
    }
}
