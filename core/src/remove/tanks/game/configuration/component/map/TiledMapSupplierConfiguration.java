package remove.tanks.game.configuration.component.map;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapSupplierConfiguration {
    @ComponentName("TmxMapLoader")
    public static final class TmxMapLoaderSupplier extends ComponentSupplier<TmxMapLoader> {
        @Override
        public TmxMapLoader supplyComponent() {
            return new TmxMapLoader();
        }
    }
}
