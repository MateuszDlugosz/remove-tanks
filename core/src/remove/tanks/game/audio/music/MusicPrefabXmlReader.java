package remove.tanks.game.audio.music;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class MusicPrefabXmlReader {
    public static final String MUSIC_ELEMENT = "music";
    public static final String MUSICS_ELEMENT = "musics";

    private static final String FILENAME_ELEMENT = "filename";

    public List<MusicPrefab> readMusicPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(MUSIC_ELEMENT).toArray())
                .map(this::readMusicPrefab)
                .collect(Collectors.toList());
    }

    public MusicPrefab readMusicPrefab(XmlReader.Element element) {
        try {
            return new MusicPrefab(readFilename(element));
        } catch (Exception e) {
            throw new MusicPrefabXmlReadException(element, e);
        }
    }

    private String readFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText().trim();
    }
}
