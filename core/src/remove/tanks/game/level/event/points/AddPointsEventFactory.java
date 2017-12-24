package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventFactory
        implements RegistrableEventFactory<AddPointsEvent, AddPointsEventPrototype>
{
    @Override
    public AddPointsEvent createEvent(AddPointsEventPrototype prototype) {
        try {
            return new AddPointsEvent(prototype.getPoints());
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<AddPointsEventPrototype> getFactoryType() {
        return AddPointsEventPrototype.class;
    }
}
