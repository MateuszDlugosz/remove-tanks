package remove.tanks.game.audio.sound.event;

import com.badlogic.gdx.audio.Sound;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEvent {
    private final Sound sound;

    public PlaySoundEvent(Sound sound) {
        this.sound = sound;
    }

    public Sound getSound() {
        return sound;
    }
}
