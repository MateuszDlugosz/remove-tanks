package remove.tanks.game.configuration.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.filter.FilterPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class FilterSupplierConfiguration {
    @ComponentName("FilterPrototypeXmlLoader")
    public static final class FilterPrototypeXmlLoaderSupplier extends ComponentSupplier<FilterPrototypeXmlLoader> {
        @Override
        public FilterPrototypeXmlLoader supplyComponent() {
            return new FilterPrototypeXmlLoader(
                    CategoryBit.getCategoryBitMap(),
                    MaskBit.getMaskBitMap()
            );
        }
    }
}
