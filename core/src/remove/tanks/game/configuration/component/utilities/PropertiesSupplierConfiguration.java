package remove.tanks.game.configuration.component.utilities;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.properties.MapPropertiesConverter;
import remove.tanks.game.utility.properties.PropertiesXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesSupplierConfiguration {
    @ComponentName("PropertiesXmlLoader")
    public static final class PropertiesXmlLoaderSupplier extends ComponentSupplier<PropertiesXmlLoader> {
        @Override
        public PropertiesXmlLoader supplyComponent() {
            return new PropertiesXmlLoader();
        }
    }

    @ComponentName("MapPropertiesConverter")
    public static final class MapPropertiesConverterSupplier extends ComponentSupplier<MapPropertiesConverter> {
        @Override
        public MapPropertiesConverter supplyComponent() {
            return new MapPropertiesConverter();
        }
    }
}
