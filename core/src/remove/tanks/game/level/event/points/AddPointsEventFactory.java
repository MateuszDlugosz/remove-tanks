package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventFactory implements SubEventFactory<AddPointsEvent, AddPointsEventPrefab> {
    @Override
    public AddPointsEvent createEvent(AddPointsEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new AddPointsEvent(prefab.getPoints());
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<AddPointsEventPrefab> getFactoryType() {
        return AddPointsEventPrefab.class;
    }
}
