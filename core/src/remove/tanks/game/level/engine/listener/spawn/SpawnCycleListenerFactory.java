package remove.tanks.game.level.engine.listener.spawn;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class SpawnCycleListenerFactory
        implements RegistrableEntityListenerFactory<SpawnCycleListener, SpawnCycleListenerPrototype>
{
    @Override
    public SpawnCycleListener createEntityListener(SpawnCycleListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new SpawnCycleListener(
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                registry.getResource(LevelResource.EntityPrototypeRepository.toString(),
                        EntityPrototypeRepository.class),
                engine,
                prototype.getPriority()
        );
    }

    @Override
    public Class<SpawnCycleListenerPrototype> getFactoryType() {
        return SpawnCycleListenerPrototype.class;
    }
}
