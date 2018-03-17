package remove.tanks.game.level.event.state;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventFactory implements SubEventFactory<ChangeLevelStateEvent, ChangeLevelStateEventPrefab> {
    @Override
    public ChangeLevelStateEvent createEvent(ChangeLevelStateEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new ChangeLevelStateEvent(prefab.getLevelState());
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ChangeLevelStateEventPrefab> getFactoryType() {
        return ChangeLevelStateEventPrefab.class;
    }
}
