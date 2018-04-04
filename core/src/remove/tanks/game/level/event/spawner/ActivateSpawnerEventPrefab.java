package remove.tanks.game.level.event.spawner;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEventPrefab extends EventPrefab {
    private final String id;

    public ActivateSpawnerEventPrefab(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
