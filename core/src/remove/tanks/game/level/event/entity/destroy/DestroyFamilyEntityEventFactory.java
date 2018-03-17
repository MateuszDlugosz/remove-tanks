package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEntityEventFactory implements SubEntityEventFactory<DestroyFamilyEntityEvent, DestroyFamilyEntityEventPrefab> {
    @Override
    public DestroyFamilyEntityEvent createEntityEvent(DestroyFamilyEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new DestroyFamilyEntityEvent(entity, prefab.getEntityFamily());
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyFamilyEntityEventPrefab> getFactoryType() {
        return DestroyFamilyEntityEventPrefab.class;
    }
}
