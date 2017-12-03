package remove.tanks.game.level.event.spawner;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class ActivateAutoSpawnerEventFactory
        implements RegistrableEventFactory<ActivateAutoSpawnerEvent, ActivateAutoSpawnerEventPrototype>
{
    @Override
    public ActivateAutoSpawnerEvent createEvent(ActivateAutoSpawnerEventPrototype prototype) {
        return new ActivateAutoSpawnerEvent(prototype.getId());
    }

    @Override
    public Class<ActivateAutoSpawnerEventPrototype> getFactoryType() {
        return ActivateAutoSpawnerEventPrototype.class;
    }
}
