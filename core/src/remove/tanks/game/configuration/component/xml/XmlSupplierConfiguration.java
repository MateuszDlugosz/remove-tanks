package remove.tanks.game.configuration.component.xml;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;

/**
 * @author Mateusz Długosz
 */
public final class XmlSupplierConfiguration {
    @ComponentName("XmlReader")
    public static final class XmlReaderSupplier extends ComponentSupplier<XmlReader> {
        @Override
        public XmlReader supplyComponent() {
            return new XmlReader();
        }
    }
}
