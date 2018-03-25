package remove.tanks.game.level;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequence {
    private final String titleTranslationEntryKey;
    private final List<String> levelPrefabFilenames;

    public LevelSequence(String titleTranslationEntryKey, List<String> levelPrefabFilenames) {
        if (levelPrefabFilenames.size() == 0) {
            throw new IllegalArgumentException("LevelSequence must contains at least one level prefab filename.");
        }
        this.titleTranslationEntryKey = titleTranslationEntryKey;
        this.levelPrefabFilenames = levelPrefabFilenames;
    }

    public String getTitleTranslationEntryKey() {
        return titleTranslationEntryKey;
    }

    public List<String> getLevelPrefabFilenames() {
        return levelPrefabFilenames;
    }
}
