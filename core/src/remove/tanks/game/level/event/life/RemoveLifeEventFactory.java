package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventFactory
        implements RegistrableEventFactory<RemoveLifeEvent, RemoveLifeEventPrototype>
{
    @Override
    public RemoveLifeEvent createEvent(RemoveLifeEventPrototype prototype) {
        return new RemoveLifeEvent();
    }

    @Override
    public Class<RemoveLifeEventPrototype> getFactoryType() {
        return RemoveLifeEventPrototype.class;
    }
}
