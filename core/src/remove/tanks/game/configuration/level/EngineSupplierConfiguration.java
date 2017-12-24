package remove.tanks.game.configuration.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.engine.EngineFactory;
import remove.tanks.game.level.engine.EnginePrototypeXmlLoader;
import remove.tanks.game.level.engine.listener.EntityListenerFactory;
import remove.tanks.game.level.engine.listener.EntityListenerPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.EntitySystemFactory;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class EngineSupplierConfiguration {
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

    @ComponentName("EnginePrototypeXmlLoader")
    public static final class EnginePrototypeXmlLoaderSupplier extends ComponentSupplier<EnginePrototypeXmlLoader> {
        @Override
        public EnginePrototypeXmlLoader supplyComponent() {
            return new EnginePrototypeXmlLoader(
                    getContext().getComponent("EntitySystemPrototypeXmlLoader", EntitySystemPrototypeXmlLoader.class),
                    getContext().getComponent("EntityListenerPrototypeXmlLoader", EntityListenerPrototypeXmlLoader.class)
            );
        }
    }
}
