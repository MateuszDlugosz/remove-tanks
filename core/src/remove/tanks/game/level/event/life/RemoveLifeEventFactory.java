package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventFactory
        implements RegistrableEventFactory<RemoveLifeEvent, RemoveLifeEventPrototype>
{
    @Override
    public RemoveLifeEvent createEvent(RemoveLifeEventPrototype prototype) {
        try {
            return new RemoveLifeEvent();
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<RemoveLifeEventPrototype> getFactoryType() {
        return RemoveLifeEventPrototype.class;
    }
}
