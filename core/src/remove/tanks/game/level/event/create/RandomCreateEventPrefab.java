package remove.tanks.game.level.event.create;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateEventPrefab extends EventPrefab {
    private final List<CreateEntryPrefab> createEntryPrefabs;

    public RandomCreateEventPrefab(List<CreateEntryPrefab> createEntryPrefabs) {
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
