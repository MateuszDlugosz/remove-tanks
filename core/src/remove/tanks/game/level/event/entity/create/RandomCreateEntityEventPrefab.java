package remove.tanks.game.level.event.entity.create;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateEntityEventPrefab extends EntityEventPrefab {
    private final List<CreateEntryPrefab> createEntryPrefabs;

    public RandomCreateEntityEventPrefab(List<CreateEntryPrefab> createEntryPrefabs) {
        this.createEntryPrefabs = createEntryPrefabs;
    }

    public List<CreateEntryPrefab> getCreateEntryPrefabs() {
        return createEntryPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("createEntryPrefabs", createEntryPrefabs)
                .toString();
    }
}
