package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.listener.EntityListenerFactory;
import remove.tanks.game.level.engine.listener.EntityListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.audio.SoundListenerFactory;
import remove.tanks.game.level.engine.listener.audio.SoundListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.bonus.BonusLootListenerFactory;
import remove.tanks.game.level.engine.listener.bonus.BonusLootListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListenerFactory;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.bonus.executor.AmmoBonusExecutor;
import remove.tanks.game.level.engine.listener.bonus.executor.BombersBonusExecutor;
import remove.tanks.game.level.engine.listener.bonus.executor.BonusExecutor;
import remove.tanks.game.level.engine.listener.bonus.executor.LifeBonusExecutor;
import remove.tanks.game.level.engine.listener.defeat.OperationDefeatListenerFactory;
import remove.tanks.game.level.engine.listener.defeat.OperationDefeatListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.enemy.EnemyDestroyListenerFactory;
import remove.tanks.game.level.engine.listener.enemy.EnemyDestroyListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.point.PointsListenerFactory;
import remove.tanks.game.level.engine.listener.point.PointsListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.spawn.SpawnCycleListenerFactory;
import remove.tanks.game.level.engine.listener.spawn.SpawnCycleListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.trigger.TriggerListenerFactory;
import remove.tanks.game.level.engine.listener.trigger.TriggerListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.victory.OperationVictoryListenerFactory;
import remove.tanks.game.level.engine.listener.victory.OperationVictoryListenerPrototypeXmlLoader;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerSupplierConfiguration {
    @ComponentName("EntityListenerFactory")
    public static final class EntityListenerFactorySupplier extends ComponentSupplier<EntityListenerFactory> {
        @Override
        public EntityListenerFactory supplyComponent() {
            return new EntityListenerFactory(
                    new RegistrableEntityListenerFactory[] {
                            new SpawnCycleListenerFactory(),
                            new SoundListenerFactory(),
                            new EnemyDestroyListenerFactory(),
                            new PointsListenerFactory(),
                            new BonusLootListenerFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new BonusPickUpListenerFactory(
                                    new BonusExecutor[] {
                                            new AmmoBonusExecutor(),
                                            new BombersBonusExecutor(),
                                            new LifeBonusExecutor()
                                    }
                            ),
                            new TriggerListenerFactory()
                    }
            );
        }
    }

    @ComponentName("EntityListenerPrototypeXmlLoader")
    public static final class EntityListenerPrototypeXmlLoaderSupplier extends ComponentSupplier<EntityListenerPrototypeXmlLoader> {
        @Override
        public EntityListenerPrototypeXmlLoader supplyComponent() {
            return new EntityListenerPrototypeXmlLoader(
                    new RegistrableEntityListenerPrototypeXmlLoader[] {
                            new SpawnCycleListenerPrototypeXmlLoader(),
                            new SoundListenerPrototypeXmlLoader(),
                            new EnemyDestroyListenerPrototypeXmlLoader(),
                            new PointsListenerPrototypeXmlLoader(),
                            new BonusLootListenerPrototypeXmlLoader(),
                            new BonusPickUpListenerPrototypeXmlLoader(),
                            new TriggerListenerPrototypeXmlLoader()
                    }
            );
        }
    }
}
