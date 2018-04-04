package remove.tanks.game.level.event.entity.life;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEntityEventFactory implements SubEntityEventFactory<RemoveLifeEntityEvent, RemoveLifeEntityEventPrefab> {
    @Override
    public RemoveLifeEntityEvent createEntityEvent(RemoveLifeEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new RemoveLifeEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<RemoveLifeEntityEventPrefab> getFactoryType() {
        return RemoveLifeEntityEventPrefab.class;
    }
}
