package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.engine.listener.bonus.executor.BonusExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class BonusPickUpListenerFactory
        implements RegistrableEntityListenerFactory<BonusPickUpListener, BonusPickUpListenerPrototype>
{
    private final BonusExecutor[] bonusExecutors;

    public BonusPickUpListenerFactory(BonusExecutor[] bonusExecutors) {
        this.bonusExecutors = bonusExecutors;
    }

    @Override
    public BonusPickUpListener createEntityListener(BonusPickUpListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new BonusPickUpListener(
                prototype.getPriority(),
                engine,
                bonusExecutors,
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                registry.getResource(LevelResource.Properties.toString(), Properties.class)

        );
    }

    @Override
    public Class<BonusPickUpListenerPrototype> getFactoryType() {
        return BonusPickUpListenerPrototype.class;
    }
}
