package remove.tanks.game.level;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequenceXmlReader {
    public static final String LEVEL_SEQUENCE_ELEMENT = "levelSequence";

    private static final String LEVEL_PREFAB_FILENAMES_ELEMENT = "levelPrefabFilenames";
    private static final String LEVEL_PREFAB_FILENAME_ELEMENT = "levelPrefabFilename";

    public LevelSequence readLevelSequence(XmlReader.Element element) {
        try {
            return new LevelSequence(readLevelPrefabFilenames(element));
        } catch (Exception e) {
            throw new LevelSequenceXmlReadException(element, e);
        }
    }

    private List<String> readLevelPrefabFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildByName(LEVEL_PREFAB_FILENAMES_ELEMENT)
                .getChildrenByName(LEVEL_PREFAB_FILENAME_ELEMENT).toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
