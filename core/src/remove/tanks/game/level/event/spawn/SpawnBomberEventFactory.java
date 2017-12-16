package remove.tanks.game.level.event.spawn;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class SpawnBomberEventFactory
        implements RegistrableEventFactory<SpawnBomberEvent, SpawnBomberEventPrototype>
{
    @Override
    public SpawnBomberEvent createEvent(SpawnBomberEventPrototype prototype) {
        return new SpawnBomberEvent();
    }

    @Override
    public Class<SpawnBomberEventPrototype> getFactoryType() {
        return SpawnBomberEventPrototype.class;
    }
}
