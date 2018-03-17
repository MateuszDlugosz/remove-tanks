package remove.tanks.game.level.engine.system.state.defeat;

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
public final class NoLifesDefeatSystemFactory implements SubEntitySystemFactory<NoLifesDefeatSystem, NoLifesDefeatSystemPrefab> {
    @Override
    public NoLifesDefeatSystem createEntitySystem(NoLifesDefeatSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new NoLifesDefeatSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    createTimer(prefab.getDelay())
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Timer createTimer(float delay) {
        return new Timer(delay);
    }

    @Override
    public Class<NoLifesDefeatSystemPrefab> getFactoryType() {
        return NoLifesDefeatSystemPrefab.class;
    }
}
