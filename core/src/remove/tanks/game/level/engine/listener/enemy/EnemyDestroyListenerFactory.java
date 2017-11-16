package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListenerFactory
        implements RegistrableEntityListenerFactory<EnemyDestroyListener, EnemyDestroyListenerPrototype>
{
    @Override
    public EnemyDestroyListener createEntityListener(EnemyDestroyListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new EnemyDestroyListener(
                engine,
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                registry.getResource(LevelResource.Properties.toString(), Properties.class),
                prototype.getPriority()
        );
    }

    @Override
    public Class<EnemyDestroyListenerPrototype> getFactoryType() {
        return EnemyDestroyListenerPrototype.class;
    }
}
