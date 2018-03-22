package remove.tanks.game.audio.music;

import remove.tanks.game.audio.AudioConfigurationStorage;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class MusicPlayerFactory {
    public MusicPlayer createMusicPlayer(AudioConfigurationStorage audioConfigurationStorage) {
        try {
            return new MusicPlayer(createMusicChannels(audioConfigurationStorage));
        } catch (Exception e) {
            throw new MusicPlayerCreateException(e);
        }
    }

    private Map<MusicChannelName, MusicChannel> createMusicChannels(AudioConfigurationStorage audioConfigurationStorage) {
        return Arrays.stream(MusicChannelName.values()).collect(
                Collectors.toMap(
                        ch -> ch,
                        ch -> new MusicChannel(ch, audioConfigurationStorage.getMusicAudioConfiguration(ch)))
                );
    }

}
