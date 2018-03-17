package remove.tanks.game.level.event.entity.life;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEntityEventFactory implements SubEntityEventFactory<AddLifeEntityEvent, AddLifeEntityEventPrefab> {
    @Override
    public AddLifeEntityEvent createEntityEvent(AddLifeEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AddLifeEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<AddLifeEntityEventPrefab> getFactoryType() {
        return AddLifeEntityEventPrefab.class;
    }
}
