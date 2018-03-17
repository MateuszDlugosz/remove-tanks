package remove.tanks.game.level.event.entity.points;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEntityEventFactory implements SubEntityEventFactory<AddPointsEntityEvent, AddPointsEntityEventPrefab> {
    @Override
    public AddPointsEntityEvent createEntityEvent(AddPointsEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AddPointsEntityEvent(entity, prefab.getPoints());
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<AddPointsEntityEventPrefab> getFactoryType() {
        return AddPointsEntityEventPrefab.class;
    }
}
