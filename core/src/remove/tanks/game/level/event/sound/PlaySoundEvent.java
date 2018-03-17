package remove.tanks.game.level.event.sound;

import com.badlogic.gdx.audio.Sound;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEvent implements Event {
    private final Sound sound;
    private final SoundChannelName soundChannelName;

    public PlaySoundEvent(Sound sound, SoundChannelName soundChannelName) {
        this.sound = sound;
        this.soundChannelName = soundChannelName;
    }

    public Sound getSound() {
        return sound;
    }

    public SoundChannelName getSoundChannelName() {
        return soundChannelName;
    }
}
