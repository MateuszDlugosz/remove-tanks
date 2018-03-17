package remove.tanks.game.level.engine.system.spawn;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RespawnSystemFactory implements SubEntitySystemFactory<RespawnSystem, RespawnSystemPrefab> {
    @Override
    public RespawnSystem createEntitySystem(RespawnSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new RespawnSystem(
                    prefab.getPriority(),
                    createTimer(prefab.getRespawnTime()),
                    registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    prefab.getEntityPrefabCode()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Timer createTimer(float respawnTime) {
        return new Timer(respawnTime);
    }

    @Override
    public Class<RespawnSystemPrefab> getFactoryType() {
        return RespawnSystemPrefab.class;
    }
}
