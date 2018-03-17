package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.listener.AbstractEntityListener;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerListener extends AbstractEntityListener {
    private final TriggerEntityFamily triggerEntityFamily;
    private final EventBus eventBus;

    public AbstractTriggerListener(int priority, TriggerEntityFamily triggerEntityFamily, Engine engine, EventBus eventBus) {
        super(priority, triggerEntityFamily.getEntityFamily().getFamily(), engine);
        this.triggerEntityFamily = triggerEntityFamily;
        this.eventBus = eventBus;
    }

    @Override
    public void entityAdded(Entity entity) {
        Optional.ofNullable(entity.getComponent(triggerEntityFamily.getTriggerComponentClass()))
                .ifPresent(tc -> tc.getEntityEvents().forEach(eventBus::post));
    }

    @Override
    public final void entityRemoved(Entity entity) {}
}
