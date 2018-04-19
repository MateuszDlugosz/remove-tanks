package remove.tanks.game.level.engine.system.artillery;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryControlSystemPrefab extends EntitySystemPrefab {
    private final float frequency;
    private final List<String> entityPrefabCodes;

    public ArtilleryControlSystemPrefab(int priority, float frequency, List<String> entityPrefabCodes) {
        super(priority);
        this.frequency = frequency;
        this.entityPrefabCodes = entityPrefabCodes;
    }

    public float getFrequency() {
        return frequency;
    }

    public List<String> getEntityPrefabCodes() {
        return entityPrefabCodes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("frequency", frequency)
                .add("entityPrefabCodes", entityPrefabCodes)
                .toString();
    }
}
