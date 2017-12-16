package remove.tanks.game.configuration.component.mode;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.LevelSequenceXmlLoader;
import remove.tanks.game.mode.operation.OperationXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class OperationSupplierConfiguration {
    @ComponentName("OperationXmlLoader")
    public static final class OperationXmlLoaderSupplier extends ComponentSupplier<OperationXmlLoader> {
        @Override
        public OperationXmlLoader supplyComponent() {
            return new OperationXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("LevelSequenceXmlLoader", LevelSequenceXmlLoader.class)
            );
        }
    }
}
