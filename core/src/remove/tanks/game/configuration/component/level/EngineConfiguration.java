package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.EngineFactory;
import remove.tanks.game.level.engine.EnginePrefabXmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerFactory;
import remove.tanks.game.level.engine.listener.EntityListenerPrefabXmlReader;
import remove.tanks.game.level.engine.system.EntitySystemFactory;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class EngineConfiguration {
    @ComponentName("EngineFactory")
    public static final class EngineFactorySupplier extends ComponentSupplier<EngineFactory> {
        @Override
        public EngineFactory supplyComponent() {
            return new EngineFactory(
                    getContext().getComponent("EntitySystemFactory", EntitySystemFactory.class),
                    getContext().getComponent("EntityListenerFactory", EntityListenerFactory.class)
            );
        }
    }

    @ComponentName("EnginePrefabXmlReader")
    public static final class EnginePrefabXmlReaderSupplier extends ComponentSupplier<EnginePrefabXmlReader> {
        @Override
        public EnginePrefabXmlReader supplyComponent() {
            return new EnginePrefabXmlReader(
                    getContext().getComponent("EntitySystemPrefabXmlReader", EntitySystemPrefabXmlReader.class),
                    getContext().getComponent("EntityListenerPrefabXmlReader", EntityListenerPrefabXmlReader.class)
            );
        }
    }
}
