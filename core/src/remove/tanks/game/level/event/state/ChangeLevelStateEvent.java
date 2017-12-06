package remove.tanks.game.level.event.state;

import remove.tanks.game.level.constant.LevelState;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEvent implements Event {
    private final LevelState levelState;

    public ChangeLevelStateEvent(LevelState levelState) {
        this.levelState = levelState;
    }

    public LevelState getLevelState() {
        return levelState;
    }
}
