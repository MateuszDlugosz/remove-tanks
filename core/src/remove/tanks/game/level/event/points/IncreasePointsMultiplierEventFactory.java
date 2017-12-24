package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEventFactory
        implements RegistrableEventFactory<IncreasePointsMultiplierEvent, IncreasePointsMultiplierEventPrototype>
{
    @Override
    public IncreasePointsMultiplierEvent createEvent(IncreasePointsMultiplierEventPrototype prototype) {
        try {
            return new IncreasePointsMultiplierEvent();
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<IncreasePointsMultiplierEventPrototype> getFactoryType() {
        return IncreasePointsMultiplierEventPrototype.class;
    }
}
