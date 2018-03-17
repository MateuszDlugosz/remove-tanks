package remove.tanks.game.level.engine.system.state.defeat;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeEndDefeatSystemFactory implements SubEntitySystemFactory<TimeEndDefeatSystem, TimeEndDefeatSystemPrefab> {
    @Override
    public TimeEndDefeatSystem createEntitySystem(TimeEndDefeatSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new TimeEndDefeatSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<TimeEndDefeatSystemPrefab> getFactoryType() {
        return TimeEndDefeatSystemPrefab.class;
    }
}
