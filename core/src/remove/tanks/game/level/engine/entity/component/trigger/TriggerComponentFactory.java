package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.event.EventFactory;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponentFactory
        implements RegistrableComponentFactory<TriggerComponent, TriggerComponentPrototype>
{
    private final EventFactory eventFactory;

    public TriggerComponentFactory(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    @Override
    public TriggerComponent createComponent(TriggerComponentPrototype prototype, Level level, Entity entity) {
        return new TriggerComponent(
                eventFactory.createEvents(prototype.getCreateEventPrototypes()),
                eventFactory.createEvents(prototype.getDestroyEventPrototypes())
        );
    }

    @Override
    public Class<TriggerComponentPrototype> getFactoryType() {
        return TriggerComponentPrototype.class;
    }
}
