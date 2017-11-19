package remove.tanks.game.level.engine.system.defeat;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class OperationDefeatSystemFactory
        implements RegistrableEntitySystemFactory<OperationDefeatSystem, OperationDefeatSystemPrototype>
{
    @Override
    public OperationDefeatSystem createEntitySystem(OperationDefeatSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new OperationDefeatSystem(
                prototype.getPriority(),
                resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                new Timer(prototype.getDelay())
        );
    }

    @Override
    public Class<OperationDefeatSystemPrototype> getFactoryType() {
        return OperationDefeatSystemPrototype.class;
    }
}
