package remove.tanks.game.level.engine.system.state.reset;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class PlayerDestroyedResetSystemFactory implements SubEntitySystemFactory<PlayerDestroyedResetSystem, PlayerDestroyedResetSystemPrefab> {
    @Override
    public PlayerDestroyedResetSystem createEntitySystem(PlayerDestroyedResetSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new PlayerDestroyedResetSystem(
                    prefab.getPriority(),
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
    public Class<PlayerDestroyedResetSystemPrefab> getFactoryType() {
        return PlayerDestroyedResetSystemPrefab.class;
    }
}
