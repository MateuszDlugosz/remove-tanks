package remove.tanks.game.audio.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class SoundPrototypeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_SOUND_PROTOTYPE_FILE
            = "audio/sound/sound-correct-prototype.xml";
    private static final String CORRECT_SOUND_PROTOTYPES_FILE
            = "audio/sound/sound-correct-prototypes.xml";
    private static final String INCORRECT_SOUND_PROTOTYPE_FILE
            = "audio/sound/sound-incorrect-prototype.xml";
    private static final String INCORRECT_SOUND_PROTOTYPES_FILE
            = "audio/sound/sound-incorrect-prototypes.xml";

    private XmlReader xmlReader;
    private SoundPrototypeXmlLoader soundPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        soundPrototypeXmlLoader = new SoundPrototypeXmlLoader();
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadSoundPrototype() {
        SoundPrototype soundPrototype = soundPrototypeXmlLoader.loadSoundPrototype(
                xmlReader.parse(Gdx.files.internal(CORRECT_SOUND_PROTOTYPE_FILE)));

        assertEquals("sound-filename", soundPrototype.getFilename());
    }

    @Test(expected = SoundPrototypeXmlLoadException.class)
    public void when_ElementIsIncorrectlyFormatted_Then_ThrowException() {
        soundPrototypeXmlLoader.loadSoundPrototype(
                xmlReader.parse(Gdx.files.internal(INCORRECT_SOUND_PROTOTYPE_FILE)));
    }

    @Test
    public void when_ElementsAreCorrectlyFormatted_Then_LoadSoundPrototypes() {
        List<SoundPrototype> soundPrototypes = soundPrototypeXmlLoader.loadSoundPrototypes(
                xmlReader.parse(Gdx.files.internal(CORRECT_SOUND_PROTOTYPES_FILE)));

        assertEquals("sound-filename-0", soundPrototypes.get(0).getFilename());
        assertEquals("sound-filename-1", soundPrototypes.get(1).getFilename());
    }

    @Test(expected = SoundPrototypeXmlLoadException.class)
    public void when_ElementsAreIncorrectlyFormatted_Then_ThrowException() {
        soundPrototypeXmlLoader.loadSoundPrototypes(
                xmlReader.parse(Gdx.files.internal(INCORRECT_SOUND_PROTOTYPES_FILE)));
    }
}