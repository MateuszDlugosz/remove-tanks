package remove.tanks.game.level.engine.listener;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubEntityListenerFactory<T extends AbstractEntityListener, U extends EntityListenerPrefab> {
    T createEntityListener(U prefab, ResourceRegistry registry, Engine engine);
    Class<U> getFactoryType();
}
