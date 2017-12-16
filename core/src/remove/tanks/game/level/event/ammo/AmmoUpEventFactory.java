package remove.tanks.game.level.event.ammo;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AmmoUpEventFactory
        implements RegistrableEventFactory<AmmoUpEvent, AmmoUpEventPrototype>
{
    @Override
    public AmmoUpEvent createEvent(AmmoUpEventPrototype prototype) {
        return new AmmoUpEvent();
    }

    @Override
    public Class<AmmoUpEventPrototype> getFactoryType() {
        return AmmoUpEventPrototype.class;
    }
}
