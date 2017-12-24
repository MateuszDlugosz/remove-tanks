package remove.tanks.game.level.event.enemy;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class DecreaseEnemiesCounterEventFactory
        implements RegistrableEventFactory<DecreaseEnemiesCounterEvent, DecreaseEnemiesCounterEventPrototype>
{
    @Override
    public DecreaseEnemiesCounterEvent createEvent(DecreaseEnemiesCounterEventPrototype prototype) {
        try {
            return new DecreaseEnemiesCounterEvent();
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<DecreaseEnemiesCounterEventPrototype> getFactoryType() {
        return DecreaseEnemiesCounterEventPrototype.class;
    }
}
