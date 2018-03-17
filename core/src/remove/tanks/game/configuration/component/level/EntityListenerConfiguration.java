package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerFactory;
import remove.tanks.game.level.engine.listener.EntityListenerPrefabXmlReader;
import remove.tanks.game.level.engine.listener.SubEntityListenerFactory;
import remove.tanks.game.level.engine.listener.SubEntityListenerPrefabXmlReader;
import remove.tanks.game.level.engine.listener.bonus.LeaveBonusListenerFactory;
import remove.tanks.game.level.engine.listener.bonus.LeaveBonusListenerPrefabXmlReader;
import remove.tanks.game.level.engine.listener.enemy.EnemyDestroyListenerFactory;
import remove.tanks.game.level.engine.listener.enemy.EnemyDestroyListenerPrefabXmlReader;
import remove.tanks.game.level.engine.listener.trigger.*;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrefabXmlReader;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerConfiguration {
    @ComponentName("EntityListenerFactory")
    public static final class EntityListenerFactorySupplier extends ComponentSupplier<EntityListenerFactory> {
        @Override
        public EntityListenerFactory supplyComponent() {
            return new EntityListenerFactory(
                    new SubEntityListenerFactory[] {
                            new CreateTriggerListenerFactory(),
                            new DestroyTriggerListenerFactory(),
                            new HitTriggerListenerFactory(),
                            new LeaveBonusListenerFactory(
                                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class)
                            ),
                            new EnemyDestroyListenerFactory(
                                    getContext().getComponent("EventFactory", EventFactory.class)
                            )
                    }
            );
        }
    }

    @ComponentName("EntityListenerPrefabXmlReader")
    public static final class EntityListenerPrefabXmlReaderSupplier extends ComponentSupplier<EntityListenerPrefabXmlReader> {
        @Override
        public EntityListenerPrefabXmlReader supplyComponent() {
            return new EntityListenerPrefabXmlReader(
                    new SubEntityListenerPrefabXmlReader[] {
                            new CreateTriggerListenerPrefabXmlReader(),
                            new DestroyTriggerListenerPrefabXmlReader(),
                            new HitTriggerListenerPrefabXmlReader(),
                            new LeaveBonusListenerPrefabXmlReader(
                                    getContext().getComponent("EntityPrefabCodeXmlReader", EntityPrefabCodeXmlReader.class)
                            ),
                            new EnemyDestroyListenerPrefabXmlReader(
                                    getContext().getComponent("EventPrefabXmlReader", EventPrefabXmlReader.class)
                            )
                    }
            );
        }
    }
}
