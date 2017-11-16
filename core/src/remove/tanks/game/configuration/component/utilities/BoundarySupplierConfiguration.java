package remove.tanks.game.configuration.component.utilities;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.boundary.BoundariesFactory;
import remove.tanks.game.utility.boundary.BoundariesPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BoundarySupplierConfiguration {
    @ComponentName("BoundariesFactory")
    public static final class BoundariesFactorySupplier extends ComponentSupplier<BoundariesFactory> {
        @Override
        public BoundariesFactory supplyComponent() {
            return new BoundariesFactory();
        }
    }

    @ComponentName("BoundariesPrototypeXmlLoader")
    public static final class BoundariesPrototypeXmlLoaderSupplier extends ComponentSupplier<BoundariesPrototypeXmlLoader> {
        @Override
        public BoundariesPrototypeXmlLoader supplyComponent() {
            return new BoundariesPrototypeXmlLoader();
        }
    }
}
