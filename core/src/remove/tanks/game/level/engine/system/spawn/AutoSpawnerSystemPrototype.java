package remove.tanks.game.level.engine.system.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;
import remove.tanks.game.level.engine.utility.spwan.spawner.SpawnerPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystemPrototype extends EntitySystemPrototype {
    private final List<SpawnerPrototype> spawnerPrototypes;

    public AutoSpawnerSystemPrototype(List<SpawnerPrototype> spawnerPrototypes, int priority) {
        super(priority);
        this.spawnerPrototypes = spawnerPrototypes;
    }

    public List<SpawnerPrototype> getSpawnerPrototypes() {
        return spawnerPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("spawnerPrototypes", spawnerPrototypes)
                .toString();
    }
}
