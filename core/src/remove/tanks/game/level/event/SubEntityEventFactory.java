package remove.tanks.game.level.event;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubEntityEventFactory<T extends EntityEvent, U extends EntityEventPrefab> {
    T createEntityEvent(U prefab, Entity entity, ResourceRegistry registry);
    Class<U> getFactoryType();
}
