package remove.tanks.game.level.event.entity.spawner;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEntityEventFactory implements SubEntityEventFactory<ActivateSpawnerEntityEvent, ActivateSpawnerEntityEventPrefab> {
    @Override
    public ActivateSpawnerEntityEvent createEntityEvent(ActivateSpawnerEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ActivateSpawnerEntityEvent(entity, prefab.getId());
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ActivateSpawnerEntityEventPrefab> getFactoryType() {
        return ActivateSpawnerEntityEventPrefab.class;
    }
}
