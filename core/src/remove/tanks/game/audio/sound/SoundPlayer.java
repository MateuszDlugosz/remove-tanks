package remove.tanks.game.audio.sound;

import com.badlogic.gdx.audio.Sound;

/**
 * @author Mateusz Długosz
 */
public final class SoundPlayer {
    public long playSound(Sound sound) {
        return sound.play();
    }
}
