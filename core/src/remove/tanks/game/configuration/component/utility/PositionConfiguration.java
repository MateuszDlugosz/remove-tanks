package remove.tanks.game.configuration.component.utility;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefabMapObjectReader;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PositionConfiguration {
    @ComponentName("PositionPrefabXmlReader")
    public static final class PositionPrefabXmlReaderSupplier extends ComponentSupplier<PositionPrefabXmlReader> {
        @Override
        public PositionPrefabXmlReader supplyComponent() {
            return new PositionPrefabXmlReader();
        }
    }

    @ComponentName("PositionPrefabMapObjectReader")
    public static final class PositionPrefabMapObjectReaderSupplier extends ComponentSupplier<PositionPrefabMapObjectReader> {
        @Override
        public PositionPrefabMapObjectReader supplyComponent() {
            return new PositionPrefabMapObjectReader();
        }
    }

    @ComponentName("PositionFactory")
    public static final class PositionFactorySupplier extends ComponentSupplier<PositionFactory> {
        @Override
        public PositionFactory supplyComponent() {
            return new PositionFactory();
        }
    }
}
