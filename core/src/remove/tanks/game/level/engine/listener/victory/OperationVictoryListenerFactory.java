package remove.tanks.game.level.engine.listener.victory;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictoryListenerFactory
        implements RegistrableEntityListenerFactory<OperationVictoryListener, OperationVictoryListenerPrototype>
{
    @Override
    public OperationVictoryListener createEntityListener(OperationVictoryListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new OperationVictoryListener(
                registry.getResource(LevelResource.Properties.name(), Properties.class),
                registry.getResource(LevelResource.EventBus.name(), EventBus.class),
                engine,
                prototype.getPriority()
        );
    }

    @Override
    public Class<OperationVictoryListenerPrototype> getFactoryType() {
        return OperationVictoryListenerPrototype.class;
    }
}
