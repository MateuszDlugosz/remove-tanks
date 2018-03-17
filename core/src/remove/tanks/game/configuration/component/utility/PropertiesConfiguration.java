package remove.tanks.game.configuration.component.utility;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.properties.MapPropertiesConverter;
import remove.tanks.game.utility.properties.PropertiesXmlReader;
import remove.tanks.game.utility.properties.PropertiesXmlWriter;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesConfiguration {
    @ComponentName("PropertiesXmlReader")
    public static final class PropertiesXmlReaderSupplier extends ComponentSupplier<PropertiesXmlReader> {
        @Override
        public PropertiesXmlReader supplyComponent() {
            return new PropertiesXmlReader();
        }
    }

    @ComponentName("MapPropertiesConverter")
    public static final class MapPropertiesConverterSupplier extends ComponentSupplier<MapPropertiesConverter> {
        @Override
        public MapPropertiesConverter supplyComponent() {
            return new MapPropertiesConverter();
        }
    }

    @ComponentName("PropertiesXmlWriter")
    public static final class PropertiesXmlWriterSupplier extends ComponentSupplier<PropertiesXmlWriter> {
        @Override
        public PropertiesXmlWriter supplyComponent() {
            return new PropertiesXmlWriter();
        }
    }
}
