package remove.tanks.game.configuration.component.graphics;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.graphics.sprite.*;

/**
 * @author Mateusz Długosz
 */
public final class SpriteConfiguration {
    @ComponentName("SpritePrefabXmlReader")
    public static final class SpritePrefabXmlReaderSupplier extends ComponentSupplier<SpritePrefabXmlReader> {
        @Override
        public SpritePrefabXmlReader supplyComponent() {
            return new SpritePrefabXmlReader(
                    new SubSpritePrefabXmlReader[] {
                            new FileSpritePrefabXmlReader(),
                            new AtlasSpritePrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("SpriteFactory")
    public static final class SpriteFactorySupplier extends ComponentSupplier<SpriteFactory> {
        @Override
        public SpriteFactory supplyComponent() {
            return new SpriteFactory(
                    new SubSpriteFactory[] {
                            new FileSpriteFactory(),
                            new AtlasSpriteFactory()
                    }
            );
        }
    }
}
