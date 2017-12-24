package remove.tanks.game.level.event.state;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventFactory
        implements RegistrableEventFactory<ChangeLevelStateEvent, ChangeLevelStateEventPrototype>
{
    @Override
    public ChangeLevelStateEvent createEvent(ChangeLevelStateEventPrototype prototype) {
        try {
            return new ChangeLevelStateEvent(prototype.getLevelState());
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    @Override
    public Class<ChangeLevelStateEventPrototype> getFactoryType() {
        return ChangeLevelStateEventPrototype.class;
    }
}
