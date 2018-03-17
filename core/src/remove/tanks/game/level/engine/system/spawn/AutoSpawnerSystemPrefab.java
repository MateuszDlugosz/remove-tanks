package remove.tanks.game.level.engine.system.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;
import remove.tanks.game.level.utility.spawner.SpawnerPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystemPrefab extends EntitySystemPrefab {
    private final List<SpawnerPrefab> spawnerPrefabs;

    public AutoSpawnerSystemPrefab(int priority, List<SpawnerPrefab> spawnerPrefabs) {
        super(priority);
        this.spawnerPrefabs = spawnerPrefabs;
    }

    public List<SpawnerPrefab> getSpawnerPrefabs() {
        return spawnerPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("spawnerPrefabs", spawnerPrefabs)
                .toString();
    }
}
