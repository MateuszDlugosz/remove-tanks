package remove.tanks.game.level.utility.spawner;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerPrefab extends Prefab {
    private final String id;
    private final List<String> entityPrefabCodes;
    private final int limit;
    private final float time;
    private final boolean autoStart;

    public SpawnerPrefab(
            String id,
            List<String> entityPrefabCodes,
            int limit,
            float time,
            boolean autoStart
    ) {
        this.id = id;
        this.entityPrefabCodes = entityPrefabCodes;
        this.limit = limit;
        this.time = time;
        this.autoStart = autoStart;
    }

    public String getId() {
        return id;
    }

    public List<String> getEntityPrefabCodes() {
        return entityPrefabCodes;
    }

    public int getLimit() {
        return limit;
    }

    public float getTime() {
        return time;
    }

    public boolean isAutoStart() {
        return autoStart;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("entityPrefabCodes", entityPrefabCodes)
                .add("limit", limit)
                .add("time", time)
                .add("autoStart", autoStart)
                .toString();
    }
}
