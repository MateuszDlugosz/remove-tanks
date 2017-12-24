package remove.tanks.game.configuration.audio;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.audio.AudioOptions;
import remove.tanks.game.audio.AudioPlayer;
import remove.tanks.game.audio.music.MusicPlayer;
import remove.tanks.game.audio.sound.SoundPlayer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AudioPlayerSupplierConfiguration {
    @ComponentName("AudioPlayer")
    public static final class AudioPlayerSupplier extends ComponentSupplier<AudioPlayer> {
        @Override
        public AudioPlayer supplyComponent() {
            Map<AudioOptions.Option, Integer> options = new HashMap<>();
            options.put(AudioOptions.Option.SoundVolume, AudioOptions.Option.SoundVolume.getDefaultValue());
            options.put(AudioOptions.Option.MusicVolume, AudioOptions.Option.MusicVolume.getDefaultValue());
            options.put(AudioOptions.Option.Pan, AudioOptions.Option.Pan.getDefaultValue());

            AudioPlayer audioPlayer = new AudioPlayer(
                    getContext().getComponent("SoundPlayer", SoundPlayer.class),
                    getContext().getComponent("MusicPlayer", MusicPlayer.class),
                    new AudioOptions(
                            options,
                            getContext().getComponent("EventBus", EventBus.class)
                    )
            );
            getContext().getComponent("EventBus", EventBus.class).register(audioPlayer);
            return audioPlayer;
        }
    }
}
