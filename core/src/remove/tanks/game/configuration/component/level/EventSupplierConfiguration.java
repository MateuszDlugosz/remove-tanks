package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.entity.EntityDestroyer;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntitySpawner;
import remove.tanks.game.level.event.*;
import remove.tanks.game.level.event.destroy.DestroyEntityEventExecutor;
import remove.tanks.game.level.event.enemy.DecreaseEnemiesCounterEventExecutor;
import remove.tanks.game.level.event.enemy.DecreaseEnemiesCounterEventFactory;
import remove.tanks.game.level.event.enemy.DecreaseEnemiesCounterEventPrototypeXmlLoader;
import remove.tanks.game.level.event.life.*;
import remove.tanks.game.level.event.points.*;
import remove.tanks.game.level.event.spawn.SpawnEntityEventExecutor;
import remove.tanks.game.level.event.spawner.ActivateAutoSpawnerEventExecutor;
import remove.tanks.game.level.event.spawner.ActivateAutoSpawnerEventFactory;
import remove.tanks.game.level.event.spawner.ActivateAutoSpawnerEventPrototypeXmlLoader;
import remove.tanks.game.level.event.state.ChangeLevelStateEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class EventSupplierConfiguration {
    @ComponentName("EventExecutor")
    public static final class EventExecutorSupplier extends ComponentSupplier<EventExecutor> {
        @Override
        public EventExecutor supplyComponent() {
            return new EventExecutor(
                    new RegistrableEventExecutor[] {
                            new SpawnEntityEventExecutor(
                                    getContext().getComponent("EntitySpawner", EntitySpawner.class),
                                    getContext().getComponent("EntityFactory", EntityFactory.class)
                            ),
                            new DestroyEntityEventExecutor(
                                    getContext().getComponent("EntityDestroyer", EntityDestroyer.class)
                            ),
                            new ActivateAutoSpawnerEventExecutor(),
                            new IncreasePointsMultiplierEventExecutor(),
                            new DecreaseEnemiesCounterEventExecutor(),
                            new AddPointsEventExecutor(),
                            new AddLifeEventExecutor(),
                            new RemoveLifeEventExecutor(),
                            new ChangeLevelStateEventExecutor()
                    }
            );
        }
    }

    @ComponentName("EventFactory")
    public static final class EventFactorySupplier extends ComponentSupplier<EventFactory> {
        @Override
        public EventFactory supplyComponent() {
            return new EventFactory(
                    new RegistrableEventFactory[] {
                            new ActivateAutoSpawnerEventFactory(),
                            new IncreasePointsMultiplierEventFactory(),
                            new DecreaseEnemiesCounterEventFactory(),
                            new AddPointsEventFactory(),
                            new AddLifeEventFactory(),
                            new RemoveLifeEventFactory()
                    }
            );
        }
    }

    @ComponentName("EventPrototypeXmlLoader")
    public static final class EventPrototypeXmlLoaderSupplier extends ComponentSupplier<EventPrototypeXmlLoader> {
        @Override
        public EventPrototypeXmlLoader supplyComponent() {
            return new EventPrototypeXmlLoader(
                    new RegistrableEventPrototypeXmlLoader[] {
                            new ActivateAutoSpawnerEventPrototypeXmlLoader(),
                            new IncreasePointsMultiplierEventPrototypeXmlLoader(),
                            new DecreaseEnemiesCounterEventPrototypeXmlLoader(),
                            new AddPointsEventPrototypeXmlLoader(),
                            new AddLifeEventPrototypeXmlLoader(),
                            new RemoveLifeEventPrototypeXmlLoader()
                    }
            );
        }
    }
}
