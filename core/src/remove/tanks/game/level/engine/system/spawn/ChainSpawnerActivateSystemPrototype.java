package remove.tanks.game.level.engine.system.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;
import remove.tanks.game.level.engine.utility.spwan.activator.SpawnerActivatorPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ChainSpawnerActivateSystemPrototype extends EntitySystemPrototype {
    private final List<SpawnerActivatorPrototype> spawnerActivatorPrototypes;

    public ChainSpawnerActivateSystemPrototype(List<SpawnerActivatorPrototype> spawnerActivatorPrototypes, int priority) {
        super(priority);
        this.spawnerActivatorPrototypes = spawnerActivatorPrototypes;
    }

    public List<SpawnerActivatorPrototype> getSpawnerActivatorPrototypes() {
        return spawnerActivatorPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("spawnerActivatorPrototypes", spawnerActivatorPrototypes)
                .toString();
    }
}
