package remove.tanks.game.level.engine.system.state.victory;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictorySystemFactory
        implements RegistrableEntitySystemFactory<OperationVictorySystem, OperationVictorySystemPrototype>
{
    @Override
    public OperationVictorySystem createEntitySystem(OperationVictorySystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new OperationVictorySystem(
                prototype.getPriority(),
                resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                new Timer(prototype.getDelay())
        );
    }

    @Override
    public Class<OperationVictorySystemPrototype> getFactoryType() {
        return OperationVictorySystemPrototype.class;
    }
}
