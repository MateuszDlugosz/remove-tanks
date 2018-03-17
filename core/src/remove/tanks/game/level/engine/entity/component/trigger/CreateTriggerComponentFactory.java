package remove.tanks.game.level.engine.entity.component.trigger;

import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.event.EntityEventFactory;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CreateTriggerComponentFactory extends AbstractTriggerComponentFactory<CreateTriggerComponent, CreateTriggerComponentPrefab> {
    public CreateTriggerComponentFactory(EntityEventFactory entityEventFactory) {
        super(entityEventFactory);
    }

    @Override
    protected CreateTriggerComponent createComponent(List<EntityEvent> entityEvents) {
        return new CreateTriggerComponent(entityEvents);
    }

    @Override
    public Class<CreateTriggerComponentPrefab> getFactoryType() {
        return CreateTriggerComponentPrefab.class;
    }
}
