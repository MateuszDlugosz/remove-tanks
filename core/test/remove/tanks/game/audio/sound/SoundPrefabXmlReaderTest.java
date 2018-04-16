package remove.tanks.game.audio.sound;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class SoundPrefabXmlReaderTest {
    private static final String SOUND_CORRECT_PREFAB =
            "<sound>" +
                    "<filename>sound-filename</filename>" +
            "</sound>";

    private static final String SOUND_INCORRECT_PREFAB =
            "<sound></sound>";

    private XmlReader xmlReader;
    private SoundPrefabXmlReader soundPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        soundPrefabXmlReader = new SoundPrefabXmlReader();
    }

    @Test
    public void Should_ReturnSoundPrefab_When_GivenElementIsCorrectlyFormatted() {
        SoundPrefab prefab = soundPrefabXmlReader.readSoundPrefab(
                xmlReader.parse(SOUND_CORRECT_PREFAB));

        assertEquals("sound-filename", prefab.getFilename());
    }

    @Test(expected = SoundPrefabXmlReadException.class)
    public void Should_ThrowException_When_GivenElementIsIncorrectlyFormatted() {
        soundPrefabXmlReader.readSoundPrefab(
                xmlReader.parse(SOUND_INCORRECT_PREFAB));
    }
}
