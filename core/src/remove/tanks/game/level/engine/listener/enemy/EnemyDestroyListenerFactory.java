package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListenerFactory
        implements RegistrableEntityListenerFactory<EnemyDestroyListener, EnemyDestroyListenerPrototype>
{
    @Override
    public EnemyDestroyListener createEntityListener(EnemyDestroyListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new EnemyDestroyListener(
                prototype.getPriority(),
                engine,
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class)
        );
    }

    @Override
    public Class<EnemyDestroyListenerPrototype> getFactoryType() {
        return EnemyDestroyListenerPrototype.class;
    }
}
