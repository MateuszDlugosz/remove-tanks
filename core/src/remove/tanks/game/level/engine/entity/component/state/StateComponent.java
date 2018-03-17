package remove.tanks.game.level.engine.entity.component.state;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.utility.state.State;

/**
 * @author Mateusz Długosz
 */
public final class StateComponent implements Component {
    public static final ComponentMapper<StateComponent> MAPPER
            = ComponentMapper.getFor(StateComponent.class);

    private final State state;

    public StateComponent(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
