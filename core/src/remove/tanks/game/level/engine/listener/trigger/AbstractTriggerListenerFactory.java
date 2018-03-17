package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.listener.EntityListenerCreateException;
import remove.tanks.game.level.engine.listener.SubEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerListenerFactory<T extends AbstractTriggerListener, U extends AbstractTriggerListenerPrefab>
        implements SubEntityListenerFactory<T, U>
{
    @Override
    public final T createEntityListener(U prefab, ResourceRegistry registry, Engine engine) {
        try {
            return createEntityListener(prefab, engine, registry.getResource(ResourceType.EventBusResource, EventBus.class));
        } catch (Exception e) {
            throw new EntityListenerCreateException(prefab, e);
        }
    }

    protected abstract T createEntityListener(U prefab, Engine engine, EventBus eventBus);

    @Override
    public abstract Class<U> getFactoryType();
}
