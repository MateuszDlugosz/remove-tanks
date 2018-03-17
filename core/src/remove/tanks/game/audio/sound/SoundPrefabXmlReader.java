package remove.tanks.game.audio.sound;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SoundPrefabXmlReader {
    public static final String SOUND_ELEMENT = "sound";
    public static final String SOUNDS_ELEMENT = "sounds";

    private static final String FILENAME_ELEMENT = "filename";

    public List<SoundPrefab> readSoundPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SOUND_ELEMENT).toArray())
                .map(this::readSoundPrefab)
                .collect(Collectors.toList());
    }

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
