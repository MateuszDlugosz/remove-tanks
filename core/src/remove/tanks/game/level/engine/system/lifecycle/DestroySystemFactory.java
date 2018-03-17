package remove.tanks.game.level.engine.system.lifecycle;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class DestroySystemFactory implements SubEntitySystemFactory<DestroySystem, DestroySystemPrefab> {
    @Override
    public DestroySystem createEntitySystem(DestroySystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new DestroySystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroySystemPrefab> getFactoryType() {
        return DestroySystemPrefab.class;
    }
}
