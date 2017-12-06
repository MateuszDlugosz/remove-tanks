package remove.tanks.game.level.event.state;

import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventFactory
        implements RegistrableEventFactory<ChangeLevelStateEvent, ChangeLevelStateEventPrototype>
{
    @Override
    public ChangeLevelStateEvent createEvent(ChangeLevelStateEventPrototype prototype) {
        return new ChangeLevelStateEvent(prototype.getLevelState());
    }

    @Override
    public Class<ChangeLevelStateEventPrototype> getFactoryType() {
        return ChangeLevelStateEventPrototype.class;
    }
}
