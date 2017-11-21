package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.entity.EntityDestroyer;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntitySpawner;
import remove.tanks.game.level.event.EventExecutor;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.level.event.destroy.DestroyEntityEventExecutor;
import remove.tanks.game.level.event.property.ModifyPropertyEventExecutor;
import remove.tanks.game.level.event.spawn.SpawnEntityEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class EventSupplierConfiguration {
    @ComponentName("EventExecutor")
    public static final class LevelEventExecutorSupplier extends ComponentSupplier<EventExecutor> {
        @Override
        public EventExecutor supplyComponent() {
            return new EventExecutor(
                    new RegistrableEventExecutor[] {
                            new ModifyPropertyEventExecutor(),
                            new SpawnEntityEventExecutor(
                                    getContext().getComponent("EntitySpawner", EntitySpawner.class),
                                    getContext().getComponent("EntityFactory", EntityFactory.class)
                            ),
                            new DestroyEntityEventExecutor(
                                    getContext().getComponent("EntityDestroyer", EntityDestroyer.class)
                            )
                    }
            );
        }
    }
}
