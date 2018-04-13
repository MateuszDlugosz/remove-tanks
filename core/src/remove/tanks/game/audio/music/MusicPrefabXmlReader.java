package remove.tanks.game.audio.music;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MusicPrefabXmlReader {
    public static final String MUSIC_ELEMENT = "music";

    private static final String FILENAME_ELEMENT = "filename";

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
