package remove.tanks.game.level;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.locale.translation.TranslationEntryKey;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequenceXmlReader {
    public static final String LEVEL_SEQUENCE_ELEMENT = "levelSequence";

    private static final String TITLE_TRANSLATION_ENTRY_KEY_ELEMENT = "titleTranslationEntryKey";
    private static final String LEVEL_PREFAB_FILENAMES_ELEMENT = "levelPrefabFilenames";
    private static final String LEVEL_PREFAB_FILENAME_ELEMENT = "levelPrefabFilename";

    public LevelSequence readLevelSequence(XmlReader.Element element) {
        try {
            return new LevelSequence(
                    readTitleTranslationEntryKey(element),
                    readLevelPrefabFilenames(element)
            );
        } catch (Exception e) {
            throw new LevelSequenceXmlReadException(element, e);
        }
    }

    private String readTitleTranslationEntryKey(XmlReader.Element element) {
        return String.format(
                TranslationEntryKey.GameLevelSequenceTitleTemplate.getName(),
                element.getChildByName(TITLE_TRANSLATION_ENTRY_KEY_ELEMENT).getText().trim()
        );
    }

    private List<String> readLevelPrefabFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildByName(LEVEL_PREFAB_FILENAMES_ELEMENT)
                .getChildrenByName(LEVEL_PREFAB_FILENAME_ELEMENT).toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
