package remove.tanks.game.audio.sound;

import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.audio.AudioConfiguration;

/**
 * @author Mateusz Długosz
 */
public final class SoundChannel {
    private final SoundChannelName soundChannelName;
    private final AudioConfiguration audioConfiguration;

    public SoundChannel(SoundChannelName soundChannelName, AudioConfiguration audioConfiguration) {
        this.soundChannelName = soundChannelName;
        this.audioConfiguration = audioConfiguration;
    }

    public SoundChannelName getSoundChannelName() {
        return soundChannelName;
    }

    public AudioConfiguration getAudioConfiguration() {
        return audioConfiguration;
    }

    public void playSound(Sound sound) {
        long id = sound.play();
        sound.setPan(
                id,
                audioConfiguration.getOptionValueAsFloat(AudioConfiguration.Option.Pan),
                audioConfiguration.getOptionValueAsFloat(AudioConfiguration.Option.Volume)
        );
    }
}
