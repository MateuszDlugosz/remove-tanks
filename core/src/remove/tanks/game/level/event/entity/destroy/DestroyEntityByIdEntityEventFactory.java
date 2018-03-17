package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEntityEventFactory implements SubEntityEventFactory<DestroyEntityByIdEntityEvent, DestroyEntityByIdEntityEventPrefab> {
    @Override
    public DestroyEntityByIdEntityEvent createEntityEvent(DestroyEntityByIdEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new DestroyEntityByIdEntityEvent(entity, prefab.getId());
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyEntityByIdEntityEventPrefab> getFactoryType() {
        return DestroyEntityByIdEntityEventPrefab.class;
    }
}
