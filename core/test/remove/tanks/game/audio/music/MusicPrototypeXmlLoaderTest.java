package remove.tanks.game.audio.music;

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
public class MusicPrototypeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_MUSIC_PROTOTYPE_FILE
            = "audio/music/music-correct-prototype.xml";
    private static final String CORRECT_MUSIC_PROTOTYPES_FILE
            = "audio/music/music-correct-prototypes.xml";
    private static final String INCORRECT_MUSIC_PROTOTYPE_FILE
            = "audio/music/music-incorrect-prototype.xml";
    private static final String INCORRECT_MUSIC_PROTOTYPES_FILE
            = "audio/music/music-incorrect-prototypes.xml";

    private XmlReader xmlReader;
    private MusicPrototypeXmlLoader musicPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        musicPrototypeXmlLoader = new MusicPrototypeXmlLoader();
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadMusicPrototype() {
        MusicPrototype musicPrototype = musicPrototypeXmlLoader.loadMusicPrototype(
                xmlReader.parse(Gdx.files.internal(CORRECT_MUSIC_PROTOTYPE_FILE)));

        assertEquals("music-filename", musicPrototype.getFilename());
    }

    @Test(expected = MusicPrototypeXmlLoadException.class)
    public void when_ElementIsIncorrectlyFormatted_Then_ThrowException() {
        musicPrototypeXmlLoader.loadMusicPrototype(
                xmlReader.parse(Gdx.files.internal(INCORRECT_MUSIC_PROTOTYPE_FILE)));
    }

    @Test
    public void when_ElementsAreCorrectlyFormatted_Then_LoadMusicPrototypes() {
        List<MusicPrototype> musicPrototypes = musicPrototypeXmlLoader.loadMusicPrototypes(
                xmlReader.parse(Gdx.files.internal(CORRECT_MUSIC_PROTOTYPES_FILE)));

        assertEquals("music-filename-0", musicPrototypes.get(0).getFilename());
        assertEquals("music-filename-1", musicPrototypes.get(1).getFilename());
    }

    @Test(expected = MusicPrototypeXmlLoadException.class)
    public void when_ElementAreIncorrectlyFormatted_Then_ThrowException() {
        musicPrototypeXmlLoader.loadMusicPrototype(
                xmlReader.parse(Gdx.files.internal(INCORRECT_MUSIC_PROTOTYPES_FILE)));
    }
}