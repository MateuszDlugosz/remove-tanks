package remove.tanks.game.configuration.utilities;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.position.PositionPrototypeMapObjectLoader;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PositionSupplierConfiguration {
    @ComponentName("PositionFactory")
    public static final class PositionFactorySupplier extends ComponentSupplier<PositionFactory> {
        @Override
        public PositionFactory supplyComponent() {
            return new PositionFactory();
        }
    }

    @ComponentName("PositionPrototypeXmlLoader")
    public static final class PositionPrototypeXmlLoaderSupplier extends ComponentSupplier<PositionPrototypeXmlLoader> {
        @Override
        public PositionPrototypeXmlLoader supplyComponent() {
            return new PositionPrototypeXmlLoader();
        }
    }

    @ComponentName("PositionPrototypeMapObjectLoader")
    public static final class PositionPrototypeMapObjectLoaderSupplier extends ComponentSupplier<PositionPrototypeMapObjectLoader> {
        @Override
        public PositionPrototypeMapObjectLoader supplyComponent() {
            return new PositionPrototypeMapObjectLoader();
        }
    }
}
