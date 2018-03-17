package remove.tanks.game.level.engine.system.time;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeUpdateSystemFactory implements SubEntitySystemFactory<TimeUpdateSystem, TimeUpdateSystemPrefab> {
    @Override
    public TimeUpdateSystem createEntitySystem(TimeUpdateSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new TimeUpdateSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<TimeUpdateSystemPrefab> getFactoryType() {
        return TimeUpdateSystemPrefab.class;
    }
}
