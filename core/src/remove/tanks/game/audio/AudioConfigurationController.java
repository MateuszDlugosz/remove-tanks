package remove.tanks.game.audio;

import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.utility.xml.XmlFormatter;

import java.util.Arrays;

/**
 * @author Mateusz Długosz
 */
public class AudioConfigurationController {
    private final AudioConfigurationFileHandleRepository audioConfigurationFileHandleRepository;
    private final AudioConfigurationStorageFactory audioConfigurationStorageFactory;
    private final AudioConfigurationXmlWriter audioConfigurationXmlWriter;
    private final XmlFormatter xmlFormatter;

    private final AudioConfigurationStorage audioConfigurationStorage;

    public AudioConfigurationController(
            AudioConfigurationFileHandleRepository audioConfigurationFileHandleRepository,
            AudioConfigurationStorageFactory audioConfigurationStorageFactory,
            AudioConfigurationXmlWriter audioConfigurationXmlWriter,
            XmlFormatter xmlFormatter
    ) {
        this.audioConfigurationFileHandleRepository = audioConfigurationFileHandleRepository;
        this.audioConfigurationStorageFactory = audioConfigurationStorageFactory;
        this.audioConfigurationXmlWriter = audioConfigurationXmlWriter;
        this.xmlFormatter = xmlFormatter;
        this.audioConfigurationStorage = initializeAudioConfigurationStorage();
    }

    public void saveAudioConfiguration() {
        try {
            saveSoundAudioConfiguration();
            saveMusicAudioConfiguration();
        } catch (Exception e) {
            throw new AudioConfigurationSaveException(e);
        }
    }

    private void saveSoundAudioConfiguration() {
        Arrays.stream(SoundChannelName.values())
                .forEach(v -> audioConfigurationFileHandleRepository.getSoundLocalConfigurationFileHandle(v)
                        .writeString(
                                xmlFormatter.formatXmlString(audioConfigurationXmlWriter.writeAudioConfiguration(
                                        audioConfigurationStorage.getSoundAudioConfiguration(v)
                                )),
                                false
                        )
                );
    }

    private void saveMusicAudioConfiguration() {
        Arrays.stream(MusicChannelName.values())
                .forEach(v -> audioConfigurationFileHandleRepository.getMusicLocalConfigurationFileHandle(v)
                        .writeString(
                                xmlFormatter.formatXmlString(audioConfigurationXmlWriter.writeAudioConfiguration(
                                        audioConfigurationStorage.getMusicAudioConfiguration(v)
                                )),
                                false
                        )
                );
    }

    public AudioConfigurationStorage getAudioConfigurationStorage() {
        return audioConfigurationStorage;
    }

    private AudioConfigurationStorage initializeAudioConfigurationStorage() {
        initializeLocalChannelConfigurationFiles();
        return audioConfigurationStorageFactory.createAudioConfigurationStorage(audioConfigurationFileHandleRepository);
    }

    private void initializeLocalChannelConfigurationFiles() {
        try {
            initializeSoundLocalChannelConfigurationFiles();
            initializeMusicLocalChannelConfigurationFiles();
        } catch (Exception e) {
            throw new AudioConfigurationInitializeException(e);
        }
    }

    private void initializeSoundLocalChannelConfigurationFiles() {
        Arrays.stream(SoundChannelName.values()).forEach(v -> {
            if (!audioConfigurationFileHandleRepository.getSoundLocalConfigurationFileHandle(v).exists()) {
                audioConfigurationFileHandleRepository.getSoundEmptyConfigurationFileHandle(v)
                        .copyTo(audioConfigurationFileHandleRepository.getSoundLocalConfigurationFileHandle(v));
            }
        });
    }

    private void initializeMusicLocalChannelConfigurationFiles() {
        Arrays.stream(MusicChannelName.values()).forEach(v -> {
            if (!audioConfigurationFileHandleRepository.getMusicLocalConfigurationFileHandle(v).exists()) {
                audioConfigurationFileHandleRepository.getMusicEmptyConfigurationFileHandle(v)
                        .copyTo(audioConfigurationFileHandleRepository.getMusicLocalConfigurationFileHandle(v));
            }
        });
    }
}
