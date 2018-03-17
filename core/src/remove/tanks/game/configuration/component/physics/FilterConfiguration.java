package remove.tanks.game.configuration.component.physics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.physics.filter.CategoryBit;
import remove.tanks.game.physics.filter.FilterPrefabXmlReader;
import remove.tanks.game.physics.filter.MaskBit;

/**
 * @author Mateusz Długosz
 */
public final class FilterConfiguration {
    @ComponentName("FilterPrefabXmlReader")
    public static final class FilterPrefabXmlReaderSupplier extends ComponentSupplier<FilterPrefabXmlReader> {
        @Override
        public FilterPrefabXmlReader supplyComponent() {
            return new FilterPrefabXmlReader(
                    CategoryBit.getCategoryBitMap(),
                    MaskBit.getMaskBitMap()
            );
        }
    }
}
