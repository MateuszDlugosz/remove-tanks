package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEventFactory
        implements RegistrableEventFactory<DestroyEntityByIdEvent, DestroyEntityByIdEventPrototype>
{
    @Override
    public DestroyEntityByIdEvent createEvent(DestroyEntityByIdEventPrototype prototype) {
        try {
            return new DestroyEntityByIdEvent(prototype.getId());
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<DestroyEntityByIdEventPrototype> getFactoryType() {
        return DestroyEntityByIdEventPrototype.class;
    }
}
