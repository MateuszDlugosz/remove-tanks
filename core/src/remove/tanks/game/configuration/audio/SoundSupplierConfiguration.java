package remove.tanks.game.configuration.audio;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPlayer;
import remove.tanks.game.audio.sound.SoundPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SoundSupplierConfiguration {
    @ComponentName("SoundPrototypeXmlLoader")
    public static final class SoundPrototypeXmlLoaderSupplier extends ComponentSupplier<SoundPrototypeXmlLoader> {
        @Override
        public SoundPrototypeXmlLoader supplyComponent() {
            return new SoundPrototypeXmlLoader();
        }
    }

    @ComponentName("SoundFactory")
    public static final class SoundFactorySupplier extends ComponentSupplier<SoundFactory> {
        @Override
        public SoundFactory supplyComponent() {
            return new SoundFactory();
        }
    }

    @ComponentName("SoundPlayer")
    public static final class SoundPlayerSupplier extends ComponentSupplier<SoundPlayer> {
        @Override
        public SoundPlayer supplyComponent() {
            return new SoundPlayer();
        }
    }
}
