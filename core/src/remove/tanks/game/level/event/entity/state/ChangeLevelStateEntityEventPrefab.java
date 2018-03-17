package remove.tanks.game.level.event.entity.state;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEntityEventPrefab extends EntityEventPrefab {
    private final LevelState levelState;

    public ChangeLevelStateEntityEventPrefab(LevelState levelState) {
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
