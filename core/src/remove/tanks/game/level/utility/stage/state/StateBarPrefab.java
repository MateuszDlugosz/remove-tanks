package remove.tanks.game.level.utility.stage.state;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class StateBarPrefab extends Prefab {
    private final List<LevelState> displayableStates;

    public StateBarPrefab(List<LevelState> displayableStates) {
        this.displayableStates = displayableStates;
    }

    public List<LevelState> getDisplayableStates() {
        return displayableStates;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("displayableStates", displayableStates)
                .toString();
    }
}
