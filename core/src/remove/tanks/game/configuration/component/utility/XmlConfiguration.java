package remove.tanks.game.configuration.component.utility;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.xml.XmlFormatter;

/**
 * @author Mateusz Długosz
 */
public final class XmlConfiguration {
    @ComponentName("XmlReader")
    public static final class XmlReaderSupplier extends ComponentSupplier<XmlReader> {
        @Override
        public XmlReader supplyComponent() {
            return new XmlReader();
        }
    }

    @ComponentName("XmlFormatter")
    public static final class XmlFormatterSupplier extends ComponentSupplier<XmlFormatter> {
        @Override
        public XmlFormatter supplyComponent() {
            return new XmlFormatter();
        }
    }
}
