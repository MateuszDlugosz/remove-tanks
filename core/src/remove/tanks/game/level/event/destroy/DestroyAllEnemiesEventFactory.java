package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class DestroyAllEnemiesEventFactory
        implements RegistrableEventFactory<DestroyAllEnemiesEvent, DestroyAllEnemiesEventPrototype>
{
    @Override
    public DestroyAllEnemiesEvent createEvent(DestroyAllEnemiesEventPrototype prototype) {
        return new DestroyAllEnemiesEvent();
    }

    @Override
    public Class<DestroyAllEnemiesEventPrototype> getFactoryType() {
        return DestroyAllEnemiesEventPrototype.class;
    }
}
