package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class DestroyAllEnemiesEventFactory
        implements RegistrableEventFactory<DestroyAllEnemiesEvent, DestroyAllEnemiesEventPrototype>
{
    @Override
    public DestroyAllEnemiesEvent createEvent(DestroyAllEnemiesEventPrototype prototype) {
        try {
            return new DestroyAllEnemiesEvent();
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<DestroyAllEnemiesEventPrototype> getFactoryType() {
        return DestroyAllEnemiesEventPrototype.class;
    }
}
