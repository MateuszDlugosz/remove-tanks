package remove.tanks.game.level.event.enemy;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class DecreaseEnemiesCounterEventFactory
        implements RegistrableEventFactory<DecreaseEnemiesCounterEvent, DecreaseEnemiesCounterEventPrototype>
{
    @Override
    public DecreaseEnemiesCounterEvent createEvent(DecreaseEnemiesCounterEventPrototype prototype) {
        return new DecreaseEnemiesCounterEvent();
    }

    @Override
    public Class<DecreaseEnemiesCounterEventPrototype> getFactoryType() {
        return DecreaseEnemiesCounterEventPrototype.class;
    }
}
