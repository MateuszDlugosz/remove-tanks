package remove.tanks.game.configuration.component.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.application.context.Context;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.audio.*;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.music.MusicPlayerFactory;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPlayerFactory;
import remove.tanks.game.utility.properties.PropertiesXmlReader;
import remove.tanks.game.utility.properties.PropertiesXmlWriter;
import remove.tanks.game.utility.xml.XmlFormatter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfiguration {
    @ComponentName("AudioPlayer")
    public static final class AudioPlayerSupplier extends ComponentSupplier<AudioPlayer> {
        @Override
        public AudioPlayer supplyComponent() {
            AudioPlayer audioPlayer = getContext().getComponent("AudioPlayerFactory", AudioPlayerFactory.class)
                    .createAudioPlayer(
                            getContext().getComponent("AudioConfigurationController", AudioConfigurationController.class)
                                    .getAudioConfigurationStorage()
                    );
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

    @ComponentName("AudioConfigurationFileHandleRepository")
    public static final class AudioConfigurationFileHandleRepositorySupplier extends ComponentSupplier<AudioConfigurationFileHandleRepository> {
        @Override
        public AudioConfigurationFileHandleRepository supplyComponent() {
            return new AudioConfigurationFileHandleRepository(
                    getSoundEmptyFileHandlesMap(getContext()),
                    getMusicEmptyFileHandlesMap(getContext()),
                    getSoundLocalFileHandlesMap(getContext()),
                    getMusicLocalFileHandlesMap(getContext())
            );
        }

        private Map<SoundChannelName, FileHandle> getSoundEmptyFileHandlesMap(Context context) {
            return Arrays.stream(SoundChannelName.values())
                    .collect(Collectors.toMap(
                            v -> v,
                            v -> Gdx.files.internal(
                                    context.getConfiguration().getOption(ConfigurationOption.GameEmptyConfigurationDirectory.getName())
                            ).child(context.getConfiguration().getOption(ConfigurationOption.GameAudioConfigurationSoundDirectory.getName()))
                                    .child(v.name() + ".xml")
                    ));
        }

        private Map<MusicChannelName, FileHandle> getMusicEmptyFileHandlesMap(Context context) {
            return Arrays.stream(MusicChannelName.values())
                    .collect(Collectors.toMap(
                            v -> v,
                            v -> Gdx.files.internal(
                                    context.getConfiguration().getOption(ConfigurationOption.GameEmptyConfigurationDirectory.getName())
                            ).child(context.getConfiguration().getOption(ConfigurationOption.GameAudioConfigurationMusicDirectory.getName()))
                                    .child(v.name() + ".xml")
                    ));
        }

        private Map<SoundChannelName, FileHandle> getSoundLocalFileHandlesMap(Context context) {
            return Arrays.stream(SoundChannelName.values())
                    .collect(Collectors.toMap(
                            v -> v,
                            v -> Gdx.files.external(
                                    context.getConfiguration().getOption(ConfigurationOption.GameLocalDataDirectory.getName())
                            ).child(context.getConfiguration().getOption(ConfigurationOption.GameLocalConfigurationDirectory.getName()))
                                    .child(context.getConfiguration().getOption(ConfigurationOption.GameAudioConfigurationSoundDirectory.getName()))
                                    .child(v.name() + ".xml")
                    ));
        }

        private Map<MusicChannelName, FileHandle> getMusicLocalFileHandlesMap(Context context) {
            return Arrays.stream(MusicChannelName.values())
                    .collect(Collectors.toMap(
                            v -> v,
                            v -> Gdx.files.external(
                                    context.getConfiguration().getOption(ConfigurationOption.GameLocalDataDirectory.getName())
                            ).child(context.getConfiguration().getOption(ConfigurationOption.GameLocalConfigurationDirectory.getName()))
                                    .child(context.getConfiguration().getOption(ConfigurationOption.GameAudioConfigurationMusicDirectory.getName()))
                                    .child(v.name() + ".xml")
                    ));
        }
    }

    @ComponentName("AudioConfigurationStorageFactory")
    public static final class AudioConfigurationStorageFactorySupplier extends ComponentSupplier<AudioConfigurationStorageFactory> {
        @Override
        public AudioConfigurationStorageFactory supplyComponent() {
            return new AudioConfigurationStorageFactory(
                    getContext().getComponent("AudioConfigurationXmlReader", AudioConfigurationXmlReader.class)
            );
        }
    }

    @ComponentName("AudioConfigurationXmlReader")
    public static final class AudioConfigurationXmlReaderSupplier extends ComponentSupplier<AudioConfigurationXmlReader> {
        @Override
        public AudioConfigurationXmlReader supplyComponent() {
            return new AudioConfigurationXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("PropertiesXmlReader", PropertiesXmlReader.class)
            );
        }
    }

    @ComponentName("AudioConfigurationXmlWriter")
    public static final class AudioConfigurationXmlWriterSupplier extends ComponentSupplier<AudioConfigurationXmlWriter> {
        @Override
        public AudioConfigurationXmlWriter supplyComponent() {
            return new AudioConfigurationXmlWriter(
                    getContext().getComponent("PropertiesXmlWriter", PropertiesXmlWriter.class),
                    getContext().getComponent("AudioConfigurationToPropertiesConverter", AudioConfigurationToPropertiesConverter.class)
            );
        }
    }

    @ComponentName("AudioConfigurationToPropertiesConverter")
    public static final class AudioConfigurationToPropertiesConverterSupplier extends ComponentSupplier<AudioConfigurationToPropertiesConverter> {
        @Override
        public AudioConfigurationToPropertiesConverter supplyComponent() {
            return new AudioConfigurationToPropertiesConverter();
        }
    }

    @ComponentName("AudioConfigurationController")
    public static final class AudioConfigurationControllerSupplier extends ComponentSupplier<AudioConfigurationController> {
        @Override
        public AudioConfigurationController supplyComponent() {
            return new AudioConfigurationController(
                    getContext().getComponent("AudioConfigurationFileHandleRepository", AudioConfigurationFileHandleRepository.class),
                    getContext().getComponent("AudioConfigurationStorageFactory", AudioConfigurationStorageFactory.class),
                    getContext().getComponent("AudioConfigurationXmlWriter", AudioConfigurationXmlWriter.class),
                    getContext().getComponent("XmlFormatter", XmlFormatter.class)
            );
        }
    }
}
