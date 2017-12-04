package remove.tanks.game.level.engine.entity.component.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SpawnOnDestroyComponentPrototype implements ComponentPrototype {
    private final List<SpawnEntryPrototype> spawnEntryPrototypes;

    public SpawnOnDestroyComponentPrototype(List<SpawnEntryPrototype> spawnEntryPrototypes) {
        this.spawnEntryPrototypes = spawnEntryPrototypes;
    }

    public List<SpawnEntryPrototype> getSpawnEntryPrototypes() {
        return spawnEntryPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("spawnEntryPrototypes", spawnEntryPrototypes)
                .toString();
    }
}
