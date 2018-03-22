package remove.tanks.game.configuration.component.audio;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPlayerFactory;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SoundConfiguration {
    @ComponentName("SoundPlayerFactory")
    public static final class SoundPlayerFactorySupplier extends ComponentSupplier<SoundPlayerFactory> {
        @Override
        public SoundPlayerFactory supplyComponent() {
            return new SoundPlayerFactory();
        }
    }

    @ComponentName("SoundFactory")
    public static final class SoundFactorySupplier extends ComponentSupplier<SoundFactory> {
        @Override
        public SoundFactory supplyComponent() {
            return new SoundFactory();
        }
    }

    @ComponentName("SoundPrefabXmlReader")
    public static final class SoundPrefabXmlReaderSupplier extends ComponentSupplier<SoundPrefabXmlReader> {
        @Override
        public SoundPrefabXmlReader supplyComponent() {
            return new SoundPrefabXmlReader();
        }
    }
}
