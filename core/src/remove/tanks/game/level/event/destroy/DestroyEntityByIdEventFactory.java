package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEventFactory
        implements RegistrableEventFactory<DestroyEntityByIdEvent, DestroyEntityByIdEventPrototype>
{
    @Override
    public DestroyEntityByIdEvent createEvent(DestroyEntityByIdEventPrototype prototype) {
        return new DestroyEntityByIdEvent(prototype.getId());
    }

    @Override
    public Class<DestroyEntityByIdEventPrototype> getFactoryType() {
        return DestroyEntityByIdEventPrototype.class;
    }
}
