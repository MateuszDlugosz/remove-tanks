package remove.tanks.game.level.engine.system;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEntitySystemFactory<T extends EntitySystem, U extends EntitySystemPrototype> {
    T createEntitySystem(U prototype, ResourceRegistry resourceRegistry);
    Class<U> getFactoryType();
}
