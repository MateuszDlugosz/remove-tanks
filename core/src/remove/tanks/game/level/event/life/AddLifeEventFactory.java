package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEventFactory implements SubEventFactory<AddLifeEvent, AddLifeEventPrefab> {
    @Override
    public AddLifeEvent createEvent(AddLifeEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new AddLifeEvent();
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<AddLifeEventPrefab> getFactoryType() {
        return AddLifeEventPrefab.class;
    }
}
