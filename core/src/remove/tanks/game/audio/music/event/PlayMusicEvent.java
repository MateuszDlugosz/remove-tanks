package remove.tanks.game.audio.music.event;

import com.badlogic.gdx.audio.Music;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEvent {
    private final Music music;

    public PlayMusicEvent(Music music) {
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }
}
