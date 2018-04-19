package remove.tanks.game.level.engine.system.cloud;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public final class CloudControlSystemFactory implements SubEntitySystemFactory<CloudControlSystem, CloudControlSystemPrefab> {
    @Override
    public CloudControlSystem createEntitySystem(CloudControlSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new CloudControlSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    registry.getResource(ResourceType.TiledMapBoundaryResource, Boundary.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<CloudControlSystemPrefab> getFactoryType() {
        return CloudControlSystemPrefab.class;
    }
}
