package remove.tanks.game.level;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelPresenterPrefab extends Prefab {
    private final List<LevelPrefab> levelPrefabs;
    private final float presentationTime;

    public LevelPresenterPrefab(List<LevelPrefab> levelPrefabs, float presentationTime) {
        this.levelPrefabs = levelPrefabs;
        this.presentationTime = presentationTime;
    }

    public List<LevelPrefab> getLevelPrefabs() {
        return levelPrefabs;
    }

    public float getPresentationTime() {
        return presentationTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("levelPrefabs", levelPrefabs)
                .add("presentationTime", presentationTime)
                .toString();
    }
}
