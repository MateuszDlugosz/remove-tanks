package remove.tanks.game.level.engine.listener.defeat;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class OperationDefeatListenerFactory
        implements RegistrableEntityListenerFactory<OperationDefeatListener, OperationDefeatListenerPrototype>
{
    @Override
    public OperationDefeatListener createEntityListener(OperationDefeatListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new OperationDefeatListener(
                registry.getResource(LevelResource.Properties.name(), Properties.class),
                registry.getResource(LevelResource.EventBus.name(), EventBus.class),
                engine,
                prototype.getPriority()
        );
    }

    @Override
    public Class<OperationDefeatListenerPrototype> getFactoryType() {
        return OperationDefeatListenerPrototype.class;
    }
}
