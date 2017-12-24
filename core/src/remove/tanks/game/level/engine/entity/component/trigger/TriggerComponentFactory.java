package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrototype;

import java.util.List;

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
        try {
            return new TriggerComponent(
                    createEvents(prototype.getCreateEventPrototypes()),
                    createEvents(prototype.getDestroyEventPrototypes())
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private List<Event> createEvents(List<EventPrototype> prototypes) {
        return eventFactory.createEvents(prototypes);
    }

    @Override
    public Class<TriggerComponentPrototype> getFactoryType() {
        return TriggerComponentPrototype.class;
    }
}
