package remove.tanks.game.level.engine.listener.point;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class PointsListenerFactory
        implements RegistrableEntityListenerFactory<PointsListener, PointsListenerPrototype>
{
    @Override
    public PointsListener createEntityListener(PointsListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new PointsListener(
                engine,
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                registry.getResource(LevelResource.Properties.toString(), Properties.class),
                prototype.getPriority()
        );
    }

    @Override
    public Class<PointsListenerPrototype> getFactoryType() {
        return PointsListenerPrototype.class;
    }
}
