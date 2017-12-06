package remove.tanks.game.level.engine.listener.points;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class PointsListenerFactory
        implements RegistrableEntityListenerFactory<PointsListener, PointsListenerPrototype>
{
    @Override
    public PointsListener createEntityListener(PointsListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new PointsListener(
                prototype.getPriority(),
                engine,
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class)
        );
    }

    @Override
    public Class<PointsListenerPrototype> getFactoryType() {
        return PointsListenerPrototype.class;
    }
}
