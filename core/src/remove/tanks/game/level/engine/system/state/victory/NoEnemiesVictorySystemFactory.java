package remove.tanks.game.level.engine.system.state.victory;

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
public final class NoEnemiesVictorySystemFactory implements SubEntitySystemFactory<NoEnemiesVictorySystem, NoEnemiesVictorySystemPrefab> {
    @Override
    public NoEnemiesVictorySystem createEntitySystem(NoEnemiesVictorySystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new NoEnemiesVictorySystem(
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
    public Class<NoEnemiesVictorySystemPrefab> getFactoryType() {
        return NoEnemiesVictorySystemPrefab.class;
    }
}
