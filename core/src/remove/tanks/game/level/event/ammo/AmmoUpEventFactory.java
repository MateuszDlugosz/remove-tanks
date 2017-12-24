package remove.tanks.game.level.event.ammo;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AmmoUpEventFactory
        implements RegistrableEventFactory<AmmoUpEvent, AmmoUpEventPrototype>
{
    @Override
    public AmmoUpEvent createEvent(AmmoUpEventPrototype prototype) {
        try {
            return new AmmoUpEvent();
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<AmmoUpEventPrototype> getFactoryType() {
        return AmmoUpEventPrototype.class;
    }
}
