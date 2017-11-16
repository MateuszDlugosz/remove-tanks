package remove.tanks.game.level.engine.entity.component.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntryPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnComponentPrototype implements ComponentPrototype {
    private final float minSpawnFrequency;
    private final float maxSpawnFrequency;
    private final List<SpawnEntryPrototype> spawnEntryPrototypes;

    public RandomSpawnComponentPrototype(
            float minSpawnFrequency,
            float maxSpawnFrequency,
            List<SpawnEntryPrototype> spawnEntryPrototypes
    ) {
        this.minSpawnFrequency = minSpawnFrequency;
        this.maxSpawnFrequency = maxSpawnFrequency;
        this.spawnEntryPrototypes = spawnEntryPrototypes;
    }

    public float getMinSpawnFrequency() {
        return minSpawnFrequency;
    }

    public float getMaxSpawnFrequency() {
        return maxSpawnFrequency;
    }

    public List<SpawnEntryPrototype> getSpawnEntryPrototypes() {
        return spawnEntryPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("minSpawnFrequency", minSpawnFrequency)
                .add("maxSpawnFrequency", maxSpawnFrequency)
                .add("spawnEntryPrototypes", spawnEntryPrototypes)
                .toString();
    }
}
