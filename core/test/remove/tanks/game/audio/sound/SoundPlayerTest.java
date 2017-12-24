package remove.tanks.game.audio.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class SoundPlayerTest extends LibGDXTest {
    private SoundPlayer soundPlayer;

    @Before
    public void initTestObjects() {
        soundPlayer = new SoundPlayer();
    }

    @Test
    public void when_SoundPlaySuccessfully_Then_IdIsGreaterThanMinusOne() {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("audio/sound/test-sound-0.ogg"));
        long id = soundPlayer.playSound(sound);

        assertTrue(id > -1);
    }
}