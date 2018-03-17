package remove.tanks.game.audio.sound;

import com.badlogic.gdx.audio.Sound;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class SoundPlayer {
    private final Map<SoundChannelName, SoundChannel> soundChannels;

    public SoundPlayer(Map<SoundChannelName, SoundChannel> soundChannels) {
        this.soundChannels = soundChannels;
    }

    public SoundChannel getSoundChannel(SoundChannelName soundChannelName) {
        return soundChannels.get(soundChannelName);
    }

    public void playSound(SoundChannelName soundChannelName, Sound sound) {
        getSoundChannel(soundChannelName).playSound(sound);
    }
}
