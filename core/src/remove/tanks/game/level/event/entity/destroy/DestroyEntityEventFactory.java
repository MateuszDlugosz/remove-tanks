package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEventFactory implements SubEntityEventFactory<DestroyEntityEvent, DestroyEntityEventPrefab> {
    @Override
    public DestroyEntityEvent createEntityEvent(DestroyEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new DestroyEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyEntityEventPrefab> getFactoryType() {
        return DestroyEntityEventPrefab.class;
    }
}
