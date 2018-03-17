package remove.tanks.game.configuration.component.utility;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.surface.boundary.BoundaryFactory;
import remove.tanks.game.utility.surface.boundary.BoundaryPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class BoundaryConfiguration {
    @ComponentName("BoundaryPrefabXmlReader")
    public static final class BoundaryPrefabXmlReaderSupplier extends ComponentSupplier<BoundaryPrefabXmlReader> {
        @Override
        public BoundaryPrefabXmlReader supplyComponent() {
            return new BoundaryPrefabXmlReader();
        }
    }

    @ComponentName("BoundaryFactory")
    public static final class BoundaryFactorySupplier extends ComponentSupplier<BoundaryFactory> {
        @Override
        public BoundaryFactory supplyComponent() {
            return new BoundaryFactory();
        }
    }
}
