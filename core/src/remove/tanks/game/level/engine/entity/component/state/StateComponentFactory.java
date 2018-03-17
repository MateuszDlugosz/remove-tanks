package remove.tanks.game.level.engine.entity.component.state;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class StateComponentFactory implements SubComponentFactory<StateComponent, StateComponentPrefab> {
    @Override
    public StateComponent createComponent(StateComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new StateComponent(prefab.getState());
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<StateComponentPrefab> getFactoryType() {
        return StateComponentPrefab.class;
    }
}
