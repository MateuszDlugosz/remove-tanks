package remove.tanks.game.level;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequence {
    private final List<String> levelPrefabFilenames;

    public LevelSequence(List<String> levelPrefabFilenames) {
        if (levelPrefabFilenames.size() == 0) {
            throw new IllegalArgumentException("LevelSequence must contains at least one level prefab filename.");
        }
        this.levelPrefabFilenames = levelPrefabFilenames;
    }

    public List<String> getLevelPrefabFilenames() {
        return levelPrefabFilenames;
    }
}
