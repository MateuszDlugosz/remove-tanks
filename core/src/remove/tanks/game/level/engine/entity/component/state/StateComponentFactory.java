package remove.tanks.game.level.engine.entity.component.state;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.engine.utility.state.State;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class StateComponentFactory
        implements RegistrableComponentFactory<StateComponent, StateComponentPrototype>
{
    @Override
    public StateComponent createComponent(StateComponentPrototype prototype, Level level, Entity entity) {
        return new StateComponent(State.valueOf(prototype.getState()));
    }

    @Override
    public Class<StateComponentPrototype> getFactoryType() {
        return StateComponentPrototype.class;
    }
}
