package remove.tanks.game.configuration.component.audio;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPlayerFactory;
import remove.tanks.game.audio.music.MusicPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MusicConfiguration {
    @ComponentName("MusicFactory")
    public static final class MusicFactorySupplier extends ComponentSupplier<MusicFactory> {
        @Override
        public MusicFactory supplyComponent() {
            return new MusicFactory();
        }
    }

    @ComponentName("MusicPrefabXmlReader")
    public static final class MusicPrefabXmlReaderSupplier extends ComponentSupplier<MusicPrefabXmlReader> {
        @Override
        public MusicPrefabXmlReader supplyComponent() {
            return new MusicPrefabXmlReader();
        }
    }

    @ComponentName("MusicPlayerFactory")
    public static final class MusicPlayerFactorySupplier extends ComponentSupplier<MusicPlayerFactory> {
        @Override
        public MusicPlayerFactory supplyComponent() {
            return new MusicPlayerFactory();
        }
    }
}
