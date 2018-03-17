package remove.tanks.game.level.event;

import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubEventFactory<T extends Event, U extends EventPrefab> {
    T createEvent(U prefab, ResourceRegistry registry);
    Class<U> getFactoryType();
}
