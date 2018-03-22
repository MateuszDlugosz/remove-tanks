package remove.tanks.game.audio;

import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.sound.SoundChannelName;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationStorageFactory {
    private final AudioConfigurationXmlReader audioConfigurationXmlReader;

    public AudioConfigurationStorageFactory(AudioConfigurationXmlReader audioConfigurationXmlReader) {
        this.audioConfigurationXmlReader = audioConfigurationXmlReader;
    }

    public AudioConfigurationStorage createAudioConfigurationStorage(AudioConfigurationFileHandleRepository repository) {
        try {
            return new AudioConfigurationStorage(
                    createSoundAudioConfigurationMap(repository),
                    createMusicAudioConfigurationMap(repository)
            );
        } catch (Exception e) {
            throw new AudioConfigurationStorageCreateException(e);
        }
    }

    private Map<SoundChannelName, AudioConfiguration> createSoundAudioConfigurationMap(AudioConfigurationFileHandleRepository repository) {
        return Arrays.stream(SoundChannelName.values())
                .collect(Collectors.toMap(
                        v -> v,
                        v -> audioConfigurationXmlReader.readAudioConfiguration(repository.getSoundLocalConfigurationFileHandle(v))
                ));
    }

    private Map<MusicChannelName, AudioConfiguration> createMusicAudioConfigurationMap(AudioConfigurationFileHandleRepository repository) {
        return Arrays.stream(MusicChannelName.values())
                .collect(Collectors.toMap(
                        v -> v,
                        v -> audioConfigurationXmlReader.readAudioConfiguration(repository.getMusicLocalConfigurationFileHandle(v))
                ));
    }
}
