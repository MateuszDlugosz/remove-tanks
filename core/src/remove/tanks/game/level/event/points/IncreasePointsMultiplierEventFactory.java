package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEventFactory
        implements RegistrableEventFactory<IncreasePointsMultiplierEvent, IncreasePointsMultiplierEventPrototype>
{
    @Override
    public IncreasePointsMultiplierEvent createEvent(IncreasePointsMultiplierEventPrototype prototype) {
        return new IncreasePointsMultiplierEvent();
    }

    @Override
    public Class<IncreasePointsMultiplierEventPrototype> getFactoryType() {
        return IncreasePointsMultiplierEventPrototype.class;
    }
}
