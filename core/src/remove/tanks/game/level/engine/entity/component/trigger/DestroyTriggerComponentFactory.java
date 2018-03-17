package remove.tanks.game.level.engine.entity.component.trigger;

import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.event.EntityEventFactory;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class DestroyTriggerComponentFactory extends AbstractTriggerComponentFactory<DestroyTriggerComponent, DestroyTriggerComponentPrefab> {
    public DestroyTriggerComponentFactory(EntityEventFactory entityEventFactory) {
        super(entityEventFactory);
    }

    @Override
    protected DestroyTriggerComponent createComponent(List<EntityEvent> entityEvents) {
        return new DestroyTriggerComponent(entityEvents);
    }

    @Override
    public Class<DestroyTriggerComponentPrefab> getFactoryType() {
        return DestroyTriggerComponentPrefab.class;
    }
}
