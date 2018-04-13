package remove.tanks.game.audio.sound;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SoundPrefabXmlReader {
    public static final String SOUND_ELEMENT = "sound";
    public static final String SOUNDS_ELEMENT = "sounds";

    private static final String FILENAME_ELEMENT = "filename";

    public SoundPrefab readSoundPrefab(XmlReader.Element element) {
        try {
            return new SoundPrefab(readFilename(element));
        } catch (Exception e) {
            throw new SoundPrefabXmlReadException(element, e);
        }
    }

    private String readFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText().trim();
    }
}
