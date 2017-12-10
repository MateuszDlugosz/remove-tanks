package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.trigger.TriggerComponent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;

/**
 * @author Mateusz Długosz
 */
public final class TriggerListener extends ExtendedEntityListener {
    private final EventBus eventBus;

    public TriggerListener(int priority, Engine engine, EventBus eventBus) {
        super(priority, EntityFamily.TriggerFamily.getFamily(), engine);
        this.eventBus = eventBus;
    }

    @Override
    public void entityAdded(Entity entity) {
        TriggerComponent.MAPPER.get(entity).getCreateEvents().forEach(eventBus::post);
    }

    @Override
    public void entityRemoved(Entity entity) {
        TriggerComponent.MAPPER.get(entity).getDestroyEvents().forEach(eventBus::post);
    }
}
