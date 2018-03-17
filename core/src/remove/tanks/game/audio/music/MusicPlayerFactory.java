package remove.tanks.game.audio.music;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.AudioConfiguration;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class MusicPlayerFactory {
    private static final String EVENT_BUS_NAME_TEMPLATE = "channel_%s";

    public MusicPlayer createMusicPlayer() {
        try {
            return new MusicPlayer(createMusicChannels());
        } catch (Exception e) {
            throw new MusicPlayerCreateException(e);
        }
    }

    private Map<MusicChannelName, MusicChannel> createMusicChannels() {
        return Arrays.stream(MusicChannelName.values()).collect(
                Collectors.toMap(
                        ch -> ch,
                        ch -> createMusicChannel(ch, new EventBus(String.format(EVENT_BUS_NAME_TEMPLATE, ch)))
                )
        );
    }

    private MusicChannel createMusicChannel(MusicChannelName musicChannelName, EventBus eventBus) {
        MusicChannel channel = new MusicChannel(musicChannelName, createMusicChannelConfiguration(eventBus));
        eventBus.register(channel);
        return channel;
    }

    private AudioConfiguration createMusicChannelConfiguration(EventBus eventBus) {
        return new AudioConfiguration(
                Arrays.stream(AudioConfiguration.Option.values())
                        .collect(Collectors.toMap(o -> o, AudioConfiguration.Option::getDefaultValue)),
                eventBus
        );
    }
}
