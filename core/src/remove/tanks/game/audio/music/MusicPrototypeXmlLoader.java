package remove.tanks.game.audio.music;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class MusicPrototypeXmlLoader {
    public static final String MUSIC_ELEMENT = "music";
    public static final String MUSICS_ELEMENT = "musics";

    private static final String FILENAME_ELEMENT = "filename";

    public List<MusicPrototype> loadMusicPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(MUSIC_ELEMENT).toArray())
                .map(this::loadMusicPrototype)
                .collect(Collectors.toList());
    }

    public MusicPrototype loadMusicPrototype(XmlReader.Element element) {
        try {
            return new MusicPrototype(loadFilename(element));
        } catch (Exception e) {
            throw new MusicPrototypeXmlLoadException(element, e);
        }
    }

    private String loadFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText().trim();
    }
}
