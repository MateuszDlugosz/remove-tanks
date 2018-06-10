package remove.tanks.game.level.mode.operation;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class OperationPrefab extends Prefab {
    private final String title;
    private final LevelSequence levelSequence;

    public OperationPrefab(String title, LevelSequence levelSequence) {
        this.title = title;
        this.levelSequence = levelSequence;
    }

    public String getTitle() {
        return title;
    }

    public LevelSequence getLevelSequence() {
        return levelSequence;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("levelSequence", levelSequence)
                .toString();
    }
}
