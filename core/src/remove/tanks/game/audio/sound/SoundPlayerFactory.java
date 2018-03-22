package remove.tanks.game.audio.sound;

import remove.tanks.game.audio.AudioConfigurationStorage;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SoundPlayerFactory {
    public SoundPlayer createSoundPlayer(AudioConfigurationStorage audioConfigurationStorage) {
        try {
            return new SoundPlayer(createSoundChannels(audioConfigurationStorage));
        } catch (Exception e) {
            throw new SoundPlayerCreateException(e);
        }
    }

    private Map<SoundChannelName, SoundChannel> createSoundChannels(AudioConfigurationStorage audioConfigurationStorage) {
        return Arrays.stream(SoundChannelName.values())
                .collect(Collectors.toMap(
                        ch -> ch,
                        ch -> new SoundChannel(ch, audioConfigurationStorage.getSoundAudioConfiguration(ch))
                ));
    }
}
