package remove.tanks.game.level.event.state;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.constant.LevelState;
import remove.tanks.game.level.event.EventPrototype;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventPrototype implements EventPrototype {
    private final LevelState levelState;

    public ChangeLevelStateEventPrototype(LevelState levelState) {
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
