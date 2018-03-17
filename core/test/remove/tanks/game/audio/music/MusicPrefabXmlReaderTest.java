package remove.tanks.game.audio.music;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class MusicPrefabXmlReaderTest {
    private static final String MUSIC_CORRECT_PREFAB =
            "<music>" +
                    "<filename>music-filename</filename>" +
            "</music>";

    private static final String MUSIC_INCORRECT_PREFAB =
            "<music></music>";

    private static final String MUSICS_CORRECT_PREFAB =
            "<musics>" +
                    "<music>" +
                    "    <filename>music-filename-0</filename>" +
                    "</music>" +
                    "<music>" +
                    "    <filename>music-filename-1</filename>" +
                    "</music>" +
            "</musics>";

    private static final String MUSICS_INCORRECT_PREFAB =
            "<musics>" +
                    "<music>" +
                    "    <filename>music-filename-0</filename>" +
                    "</music>" +
                    "<music>" +
                    "</music>" +
            "</musics>";

    private XmlReader xmlReader;
    private MusicPrefabXmlReader musicPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        musicPrefabXmlReader = new MusicPrefabXmlReader();
    }

    @Test
    public void Should_ReturnMusicPrefab_When_GivenElementIsCorrectlyFormatted() {
        MusicPrefab prefab = musicPrefabXmlReader.readMusicPrefab(
                xmlReader.parse(MUSIC_CORRECT_PREFAB));

        assertEquals("music-filename", prefab.getFilename());
    }

    @Test(expected = MusicPrefabXmlReadException.class)
    public void Should_ThrowException_When_GivenElementIsIncorrectlyFormatted() {
        musicPrefabXmlReader.readMusicPrefab(
                xmlReader.parse(MUSIC_INCORRECT_PREFAB));
    }

    @Test
    public void Should_ReturnMusicPrefabs_When_GivenElementIsCorrectlyFormatted() {
        List<MusicPrefab> prefabs = musicPrefabXmlReader.readMusicPrefabs(
                xmlReader.parse(MUSICS_CORRECT_PREFAB));

        assertEquals("music-filename-0", prefabs.get(0).getFilename());
        assertEquals("music-filename-1", prefabs.get(1).getFilename());
    }

    @Test(expected = MusicPrefabXmlReadException.class)
    public void Should_ThrowException_When_AlLeastOneOfGivenElementIsIncorrectlyFormatted() {
        musicPrefabXmlReader.readMusicPrefabs(
                xmlReader.parse(MUSICS_INCORRECT_PREFAB));
    }
}
