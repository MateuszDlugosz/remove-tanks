package remove.tanks.game.level.engine.listener;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEntityListenerFactory<T extends ExtendedEntityListener, U extends EntityListenerPrototype> {
    T createEntityListener(U prototype, ResourceRegistry registry, Engine engine);
    Class<U> getFactoryType();
}
