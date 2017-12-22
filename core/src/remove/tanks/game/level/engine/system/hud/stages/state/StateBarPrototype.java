package remove.tanks.game.level.engine.system.hud.stages.state;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.constant.LevelState;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class StateBarPrototype implements Serializable {
    private final List<LevelState> displayableStates;

    public StateBarPrototype(List<LevelState> displayableStates) {
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
