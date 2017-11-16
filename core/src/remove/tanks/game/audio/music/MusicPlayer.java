package remove.tanks.game.audio.music;

import com.badlogic.gdx.audio.Music;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class MusicPlayer {
    private Music musicPlayed;

    public Optional<Music> getMusicPlayed() {
        return Optional.ofNullable(musicPlayed);
    }

    public void playMusic(Music music) {
        music.play();
        musicPlayed = music;
    }

    public void stopMusic() {
        getMusicPlayed().ifPresent(Music::stop);
    }

    public void pauseMusic() {
        getMusicPlayed().ifPresent(Music::pause);
    }

    public void resumeMusic() {
        getMusicPlayed().ifPresent(Music::play);
    }
}
