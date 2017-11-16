package remove.tanks.game.level.engine.entity.component.state;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class StateComponentPrototype implements ComponentPrototype {
    private final String state;

    public StateComponentPrototype(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("state", state)
                .toString();
    }
}
