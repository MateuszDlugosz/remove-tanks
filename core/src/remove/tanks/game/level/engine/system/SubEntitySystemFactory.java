package remove.tanks.game.level.engine.system;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubEntitySystemFactory<T extends EntitySystem, U extends EntitySystemPrefab> {
    T createEntitySystem(U prefab, ResourceRegistry registry);
    Class<U> getFactoryType();
}