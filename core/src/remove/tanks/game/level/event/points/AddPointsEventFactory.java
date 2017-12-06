package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventFactory
        implements RegistrableEventFactory<AddPointsEvent, AddPointsEventPrototype>
{
    @Override
    public AddPointsEvent createEvent(AddPointsEventPrototype prototype) {
        return new AddPointsEvent(prototype.getPoints());
    }

    @Override
    public Class<AddPointsEventPrototype> getFactoryType() {
        return AddPointsEventPrototype.class;
    }
}
