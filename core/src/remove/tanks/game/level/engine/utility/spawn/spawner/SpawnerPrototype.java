package remove.tanks.game.level.engine.utility.spawn.spawner;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerPrototype implements Serializable {
    private final String id;
    private final boolean active;
    private final int limit;
    private final float frequency;
    private final List<String> prototypeCodes;

    public SpawnerPrototype(
            String id,
            boolean active,
            int limit,
            float frequency,
            List<String> prototypeCodes
    ) {
        this.id = id;
        this.active = active;
        this.limit = limit;
        this.frequency = frequency;
        this.prototypeCodes = prototypeCodes;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public int getLimit() {
        return limit;
    }

    public float getFrequency() {
        return frequency;
    }

    public List<String> getPrototypeCodes() {
        return prototypeCodes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("active", active)
                .add("limit", limit)
                .add("frequency", frequency)
                .add("prototypeCodes", prototypeCodes)
                .toString();
    }
}
