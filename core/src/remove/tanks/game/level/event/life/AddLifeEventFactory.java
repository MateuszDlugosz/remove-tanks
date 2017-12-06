package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEventFactory
        implements RegistrableEventFactory<AddLifeEvent, AddLifeEventPrototype>
{
    @Override
    public AddLifeEvent createEvent(AddLifeEventPrototype prototype) {
        return new AddLifeEvent();
    }

    @Override
    public Class<AddLifeEventPrototype> getFactoryType() {
        return AddLifeEventPrototype.class;
    }
}
