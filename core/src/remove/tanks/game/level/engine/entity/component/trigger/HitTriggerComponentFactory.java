package remove.tanks.game.level.engine.entity.component.trigger;

import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.event.EntityEventFactory;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HitTriggerComponentFactory extends AbstractTriggerComponentFactory<HitTriggerComponent, HitTriggerComponentPrefab> {
    public HitTriggerComponentFactory(EntityEventFactory entityEventFactory) {
        super(entityEventFactory);
    }

    @Override
    protected HitTriggerComponent createComponent(List<EntityEvent> entityEvents) {
        return new HitTriggerComponent(entityEvents);
    }

    @Override
    public Class<HitTriggerComponentPrefab> getFactoryType() {
        return HitTriggerComponentPrefab.class;
    }
}
