package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventFactory implements SubEventFactory<RemoveLifeEvent, RemoveLifeEventPrefab> {
    @Override
    public RemoveLifeEvent createEvent(RemoveLifeEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new RemoveLifeEvent();
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<RemoveLifeEventPrefab> getFactoryType() {
        return RemoveLifeEventPrefab.class;
    }
}
