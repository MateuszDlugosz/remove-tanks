package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.asset.AssetIdXmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.preload.PreloadDataXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PreloadDataConfiguration {
    @ComponentName("PreloadDataXmlReader")
    public static final class PreloadDataXmlReaderSupplier extends ComponentSupplier<PreloadDataXmlReader> {
        @Override
        public PreloadDataXmlReader supplyComponent() {
            return new PreloadDataXmlReader(
                    getContext().getComponent("EntityPrefabCodeXmlReader", EntityPrefabCodeXmlReader.class),
                    getContext().getComponent("AssetIdXmlReader", AssetIdXmlReader.class)
            );
        }
    }
}
