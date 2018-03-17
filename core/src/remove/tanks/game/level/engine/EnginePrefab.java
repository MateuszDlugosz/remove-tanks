package remove.tanks.game.level.engine;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrefab;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class EnginePrefab extends Prefab {
    private final List<EntitySystemPrefab> systemsPrefabs;
    private final List<EntityListenerPrefab> listenersPrefabs;

    public EnginePrefab(
            List<EntitySystemPrefab> systemsPrefabs,
            List<EntityListenerPrefab> listenersPrefabs
    ) {
        this.systemsPrefabs = systemsPrefabs;
        this.listenersPrefabs = listenersPrefabs;
    }

    public List<EntitySystemPrefab> getSystemsPrefabs() {
        return systemsPrefabs;
    }

    public List<EntityListenerPrefab> getListenersPrefabs() {
        return listenersPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("systemsPrefabs", systemsPrefabs)
                .add("listenersPrefabs", listenersPrefabs)
                .toString();
    }
}

