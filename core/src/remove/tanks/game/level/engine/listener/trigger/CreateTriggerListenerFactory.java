package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;

/**
 * @author Mateusz Długosz
 */
public final class CreateTriggerListenerFactory extends AbstractTriggerListenerFactory<CreateTriggerListener, CreateTriggerListenerPrefab> {
    @Override
    protected CreateTriggerListener createEntityListener(CreateTriggerListenerPrefab prefab, Engine engine, EventBus eventBus) {
        return new CreateTriggerListener(prefab.getPriority(), engine, eventBus);
    }

    @Override
    public Class<CreateTriggerListenerPrefab> getFactoryType() {
        return CreateTriggerListenerPrefab.class;
    }
}
