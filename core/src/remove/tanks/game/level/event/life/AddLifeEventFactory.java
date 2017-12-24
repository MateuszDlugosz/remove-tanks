package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEventFactory
        implements RegistrableEventFactory<AddLifeEvent, AddLifeEventPrototype>
{
    @Override
    public AddLifeEvent createEvent(AddLifeEventPrototype prototype) {
        try {
            return new AddLifeEvent();
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<AddLifeEventPrototype> getFactoryType() {
        return AddLifeEventPrototype.class;
    }
}
