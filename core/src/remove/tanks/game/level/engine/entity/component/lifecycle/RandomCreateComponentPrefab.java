package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateComponentPrefab extends ComponentPrefab {
    private final float minCreateFrequency;
    private final float maxCreateFrequency;
    private final List<CreateEntryPrefab> createEntryPrefabs;

    public RandomCreateComponentPrefab(
            float minCreateFrequency,
            float maxCreateFrequency,
            List<CreateEntryPrefab> createEntryPrefabs
    ) {
        this.minCreateFrequency = minCreateFrequency;
        this.maxCreateFrequency = maxCreateFrequency;
        this.createEntryPrefabs = createEntryPrefabs;
    }

    public float getMinCreateFrequency() {
        return minCreateFrequency;
    }

    public float getMaxCreateFrequency() {
        return maxCreateFrequency;
    }

    public List<CreateEntryPrefab> getCreateEntryPrefabs() {
        return createEntryPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("minCreateFrequency", minCreateFrequency)
                .add("maxCreateFrequency", maxCreateFrequency)
                .add("createEntryPrefabs", createEntryPrefabs)
                .toString();
    }
}
