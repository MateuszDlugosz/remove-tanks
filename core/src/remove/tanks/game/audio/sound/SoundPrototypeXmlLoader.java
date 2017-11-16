package remove.tanks.game.audio.sound;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SoundPrototypeXmlLoader {
    public static final String SOUND_ELEMENT = "sound";
    public static final String SOUNDS_ELEMENT = "sounds";

    private static final String FILENAME_ELEMENT = "filename";

    public List<SoundPrototype> loadSoundPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SOUND_ELEMENT).toArray())
                .map(this::loadSoundPrototype)
                .collect(Collectors.toList());
    }

    public SoundPrototype loadSoundPrototype(XmlReader.Element element) {
        try {
            return new SoundPrototype(loadFilename(element));
        } catch (Exception e) {
            throw new SoundPrototypeXmlLoadException(element, e);
        }
    }

    private String loadFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText().trim();
    }
}
