package remove.tanks.game.configuration.component.operation;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.LevelSequenceXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class OperationSupplierConfiguration {
    @ComponentName("LevelSequenceXmlLoader")
    public static final class OperationXmlLoaderSupplier extends ComponentSupplier<LevelSequenceXmlLoader> {
        @Override
        public LevelSequenceXmlLoader supplyComponent() {
            return new LevelSequenceXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }
}
