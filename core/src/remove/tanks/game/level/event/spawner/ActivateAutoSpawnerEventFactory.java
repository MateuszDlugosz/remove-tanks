package remove.tanks.game.level.event.spawner;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class ActivateAutoSpawnerEventFactory
        implements RegistrableEventFactory<ActivateAutoSpawnerEvent, ActivateAutoSpawnerEventPrototype>
{
    @Override
    public ActivateAutoSpawnerEvent createEvent(ActivateAutoSpawnerEventPrototype prototype) {
        try {
            return new ActivateAutoSpawnerEvent(prototype.getId());
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<ActivateAutoSpawnerEventPrototype> getFactoryType() {
        return ActivateAutoSpawnerEventPrototype.class;
    }
}
