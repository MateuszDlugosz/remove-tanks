package remove.tanks.game.configuration.component.audio;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPlayer;
import remove.tanks.game.audio.music.MusicPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class MusicSupplierConfiguration {
    @ComponentName("MusicPrototypeXmlLoader")
    public static final class MusicPrototypeXmlLoaderSupplier extends ComponentSupplier<MusicPrototypeXmlLoader> {
        @Override
        public MusicPrototypeXmlLoader supplyComponent() {
            return new MusicPrototypeXmlLoader();
        }
    }

    @ComponentName("MusicFactory")
    public static final class MusicFactorySupplier extends ComponentSupplier<MusicFactory> {
        @Override
        public MusicFactory supplyComponent() {
            return new MusicFactory();
        }
    }

    @ComponentName("MusicPlayer")
    public static final class MusicPlayerSupplier extends ComponentSupplier<MusicPlayer> {
        @Override
        public MusicPlayer supplyComponent() {
            return new MusicPlayer();
        }
    }
}
