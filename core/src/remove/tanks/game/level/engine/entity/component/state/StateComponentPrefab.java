package remove.tanks.game.level.engine.entity.component.state;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.utility.state.State;

/**
 * @author Mateusz Długosz
 */
public final class StateComponentPrefab extends ComponentPrefab {
    private final State state;

    public StateComponentPrefab(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("state", state)
                .toString();
    }
}
