package remove.tanks.game.configuration.component.graphic;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphic.sprite.*;

/**
 * @author Mateusz Długosz
 */
public final class SpriteSupplierConfiguration {
    @ComponentName("SpriteFactory")
    public static final class SpriteFactorySupplier extends ComponentSupplier<SpriteFactory> {
        @Override
        public SpriteFactory supplyComponent() {
            return new SpriteFactory(
                    new RegistrableSpriteFactory[] {
                            new FileSpriteFactory(),
                            new AtlasSpriteFactory()
                    }
            );
        }
    }

    @ComponentName("SpritePrototypeXmlLoader")
    public static final class SpritePrototypeXmlLoaderSupplier extends ComponentSupplier<SpritePrototypeXmlLoader> {
        @Override
        public SpritePrototypeXmlLoader supplyComponent() {
            return new SpritePrototypeXmlLoader(
                    new RegistrableSpritePrototypeXmlLoader[] {
                            new FileSpritePrototypeXmlLoader(),
                            new AtlasSpritePrototypeXmlLoader()
                    }
            );
        }
    }
}
