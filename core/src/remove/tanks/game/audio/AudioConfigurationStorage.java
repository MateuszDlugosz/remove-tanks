package remove.tanks.game.audio;

import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.sound.SoundChannelName;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationStorage {
    private final Map<SoundChannelName, AudioConfiguration> soundAudioConfigurations;
    private final Map<MusicChannelName, AudioConfiguration> musicAudioConfigurations;

    public AudioConfigurationStorage(
            Map<SoundChannelName, AudioConfiguration> soundAudioConfigurations,
            Map<MusicChannelName, AudioConfiguration> musicAudioConfigurations
    ) {
        this.soundAudioConfigurations = soundAudioConfigurations;
        this.musicAudioConfigurations = musicAudioConfigurations;
    }

    public AudioConfiguration getSoundAudioConfiguration(SoundChannelName soundChannelName) {
        if (!soundAudioConfigurations.containsKey(soundChannelName)) {
            throw new AudioConfigurationNotFoundException(soundChannelName.name());
        }
        return soundAudioConfigurations.get(soundChannelName);
    }

    public AudioConfiguration getMusicAudioConfiguration(MusicChannelName musicChannelName) {
        if (!musicAudioConfigurations.containsKey(musicChannelName)) {
            throw new AudioConfigurationNotFoundException(musicChannelName.name());
        }
        return musicAudioConfigurations.get(musicChannelName);
    }
}
