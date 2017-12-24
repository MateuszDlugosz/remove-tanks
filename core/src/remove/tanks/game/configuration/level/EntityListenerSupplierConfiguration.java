package remove.tanks.game.configuration.level;

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
import remove.tanks.game.level.engine.listener.spawn.SpawnCycleListenerFactory;
import remove.tanks.game.level.engine.listener.spawn.SpawnCycleListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.trigger.TriggerListenerFactory;
import remove.tanks.game.level.engine.listener.trigger.TriggerListenerPrototypeXmlLoader;
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
                            new BonusLootListenerFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
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
                            new BonusLootListenerPrototypeXmlLoader(),
                            new TriggerListenerPrototypeXmlLoader()
                    }
            );
        }
    }
}
