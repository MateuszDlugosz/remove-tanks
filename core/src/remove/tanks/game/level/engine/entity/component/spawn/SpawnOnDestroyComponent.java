package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SpawnOnDestroyComponent implements Component {
    public static final ComponentMapper<SpawnOnDestroyComponent> MAPPER
            = ComponentMapper.getFor(SpawnOnDestroyComponent.class);

    private final List<SpawnEntry> spawnEntries;

    public SpawnOnDestroyComponent(List<SpawnEntry> spawnEntries) {
        this.spawnEntries = spawnEntries;
    }

    public List<SpawnEntry> getSpawnEntries() {
        return spawnEntries;
    }
}
