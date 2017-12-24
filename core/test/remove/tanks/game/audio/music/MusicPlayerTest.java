package remove.tanks.game.audio.music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class MusicPlayerTest extends LibGDXTest {
    private MusicPlayer musicPlayer;

    @Before
    public void initTestObjects() {
        musicPlayer = new MusicPlayer();
    }

    @Test
    public void when_MusicPlaySuccessfully_Then_MusicPlayerReturnItAsPlayingMusic() {
        Music music = Gdx.audio.newMusic(Gdx.files.internal("audio/music/test-music-0.ogg"));
        musicPlayer.playMusic(music);

        assertEquals(music, musicPlayer.getMusicPlayed().get());
    }
}