package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;

/**
 * @author Mateusz Długosz
 */
public final class DestroyTriggerListener extends AbstractTriggerListener {
    public DestroyTriggerListener(int priority, Engine engine, EventBus eventBus) {
        super(priority, TriggerEntityFamily.DestroyTriggerFamily, engine, eventBus);
    }
}
