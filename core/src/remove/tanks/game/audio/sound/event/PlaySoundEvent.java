package remove.tanks.game.audio.sound.event;

import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.audio.sound.SoundChannelName;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEvent {
    private final SoundChannelName soundChannelName;
    private final Sound sound;

    public PlaySoundEvent(SoundChannelName soundChannelName, Sound sound) {
        this.soundChannelName = soundChannelName;
        this.sound = sound;
    }

    public SoundChannelName getSoundChannelName() {
        return soundChannelName;
    }

    public Sound getSound() {
        return sound;
    }
}
