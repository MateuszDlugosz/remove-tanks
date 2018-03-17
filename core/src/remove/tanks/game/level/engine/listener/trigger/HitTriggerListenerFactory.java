package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;

/**
 * @author Mateusz Długosz
 */
public final class HitTriggerListenerFactory extends AbstractTriggerListenerFactory<HitTriggerListener, HitTriggerListenerPrefab> {
    @Override
    protected HitTriggerListener createEntityListener(HitTriggerListenerPrefab prefab, Engine engine, EventBus eventBus) {
        return new HitTriggerListener(prefab.getPriority(), engine, eventBus);
    }

    @Override
    public Class<HitTriggerListenerPrefab> getFactoryType() {
        return HitTriggerListenerPrefab.class;
    }
}
