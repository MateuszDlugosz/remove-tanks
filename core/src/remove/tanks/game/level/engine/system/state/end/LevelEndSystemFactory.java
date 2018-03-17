package remove.tanks.game.level.engine.system.state.end;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LevelEndSystemFactory implements SubEntitySystemFactory<LevelEndSystem, LevelEndSystemPrefab> {
    @Override
    public LevelEndSystem createEntitySystem(LevelEndSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new LevelEndSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
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
    public Class<LevelEndSystemPrefab> getFactoryType() {
        return LevelEndSystemPrefab.class;
    }
}
