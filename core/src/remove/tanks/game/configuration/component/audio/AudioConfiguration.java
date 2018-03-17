package remove.tanks.game.configuration.component.audio;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.AudioPlayer;
import remove.tanks.game.audio.AudioPlayerFactory;
import remove.tanks.game.audio.music.MusicFactory;
import remove.tanks.game.audio.music.MusicPlayerFactory;
import remove.tanks.game.audio.music.MusicPrefabXmlReader;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPlayerFactory;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfiguration {
    @ComponentName("AudioPlayer")
    public static final class AudioPlayerSupplier extends ComponentSupplier<AudioPlayer> {
        @Override
        public AudioPlayer supplyComponent() {
            AudioPlayer audioPlayer = getContext().getComponent("AudioPlayerFactory", AudioPlayerFactory.class)
                    .createAudioPlayer();
            getContext().getComponent("EventBus", EventBus.class).register(audioPlayer);
            return audioPlayer;
        }
    }

    @ComponentName("AudioPlayerFactory")
    public static final class AudioPlayerFactorySupplier extends ComponentSupplier<AudioPlayerFactory> {
        @Override
        public AudioPlayerFactory supplyComponent() {
            return new AudioPlayerFactory(
                    getContext().getComponent("SoundPlayerFactory", SoundPlayerFactory.class),
                    getContext().getComponent("MusicPlayerFactory", MusicPlayerFactory.class)
            );
        }
    }

    @ComponentName("SoundPlayerFactory")
    public static final class SoundPlayerFactorySupplier extends ComponentSupplier<SoundPlayerFactory> {
        @Override
        public SoundPlayerFactory supplyComponent() {
            return new SoundPlayerFactory();
        }
    }

    @ComponentName("MusicPlayerFactory")
    public static final class MusicPlayerFactorySupplier extends ComponentSupplier<MusicPlayerFactory> {
        @Override
        public MusicPlayerFactory supplyComponent() {
            return new MusicPlayerFactory();
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
}
