package remove.tanks.game.audio.sound;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.AudioConfiguration;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SoundPlayerFactory {
    public SoundPlayer createSoundPlayer() {
        try {
            return new SoundPlayer(createSoundChannels());
        } catch (Exception e) {
            throw new SoundPlayerCreateException(e);
        }
    }

    private Map<SoundChannelName, SoundChannel> createSoundChannels() {
        return Arrays.stream(SoundChannelName.values())
                .collect(Collectors.toMap(
                        ch -> ch,
                        ch -> new SoundChannel(ch, createSoundChannelConfiguration(new EventBus()))
                ));
    }

    private AudioConfiguration createSoundChannelConfiguration(EventBus eventBus) {
        return new AudioConfiguration(
                Arrays.stream(AudioConfiguration.Option.values())
                        .collect(Collectors.toMap(o -> o, AudioConfiguration.Option::getDefaultValue)),
                eventBus
        );
    }
}
