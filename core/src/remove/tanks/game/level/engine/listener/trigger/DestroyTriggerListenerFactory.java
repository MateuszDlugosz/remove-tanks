package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;

/**
 * @author Mateusz Długosz
 */
public final class DestroyTriggerListenerFactory extends AbstractTriggerListenerFactory<DestroyTriggerListener, DestroyTriggerListenerPrefab> {
    @Override
    protected DestroyTriggerListener createEntityListener(DestroyTriggerListenerPrefab prefab, Engine engine, EventBus eventBus) {
        return new DestroyTriggerListener(prefab.getPriority(), engine, eventBus);
    }

    @Override
    public Class<DestroyTriggerListenerPrefab> getFactoryType() {
        return DestroyTriggerListenerPrefab.class;
    }
}
