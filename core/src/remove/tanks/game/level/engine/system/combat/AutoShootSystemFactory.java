package remove.tanks.game.level.engine.system.combat;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootSystemFactory implements SubEntitySystemFactory<AutoShootSystem, AutoShootSystemPrefab> {
    @Override
    public AutoShootSystem createEntitySystem(AutoShootSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new AutoShootSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<AutoShootSystemPrefab> getFactoryType() {
        return AutoShootSystemPrefab.class;
    }
}
