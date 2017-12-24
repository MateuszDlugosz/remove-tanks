package remove.tanks.game.level.engine.entity.component.state;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.engine.utility.state.State;

/**
 * @author Mateusz Długosz
 */
public final class StateComponentFactory
        implements RegistrableComponentFactory<StateComponent, StateComponentPrototype>
{
    @Override
    public StateComponent createComponent(StateComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new StateComponent(
                    createState(prototype.getState())
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private State createState(String state) {
        return State.valueOf(state);
    }

    @Override
    public Class<StateComponentPrototype> getFactoryType() {
        return StateComponentPrototype.class;
    }
}
