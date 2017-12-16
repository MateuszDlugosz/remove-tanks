package remove.tanks.game.level;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequenceXmlLoader {
    public static final String LEVEL_SEQUENCE_ELEMENT = "levelSequence";

    private static final String LEVEL_PROTOTYPE_FILENAMES_ELEMENT = "levelPrototypeFilenames";
    private static final String LEVEL_PROTOTYPE_FILENAME_ELEMENT = "levelPrototypeFilename";

    public LevelSequence loadLevelSequence(XmlReader.Element element) {
        try {
            return new LevelSequence(
                    loadLevelPrototypeFilenames(element)
            );
        } catch (Exception e) {
            throw new LevelSequenceXmlLoadException(element, e);
        }
    }

    private List<String> loadLevelPrototypeFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildByName(LEVEL_PROTOTYPE_FILENAMES_ELEMENT)
                .getChildrenByName(LEVEL_PROTOTYPE_FILENAME_ELEMENT).toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
