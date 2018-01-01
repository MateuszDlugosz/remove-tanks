package remove.tanks.game.level.engine.system.state.defeat;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeEndDefeatSystemFactory
        implements RegistrableEntitySystemFactory<TimeEndDefeatSystem, TimeEndDefeatSystemPrototype>
{
    @Override
    public TimeEndDefeatSystem createEntitySystem(TimeEndDefeatSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new TimeEndDefeatSystem(
                    prototype.getPriority(),
                    resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<TimeEndDefeatSystemPrototype> getFactoryType() {
        return TimeEndDefeatSystemPrototype.class;
    }
}
