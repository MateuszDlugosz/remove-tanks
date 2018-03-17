package remove.tanks.game.level.event.state;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventPrefab extends EventPrefab {
    private final LevelState levelState;

    public ChangeLevelStateEventPrefab(LevelState levelState) {
        this.levelState = levelState;
    }

    public LevelState getLevelState() {
        return levelState;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("levelState", levelState)
                .toString();
    }
}
