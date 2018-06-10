package remove.tanks.game.level.mode.operation;

import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.mode.Mode;

/**
 * @author Mateusz Długosz
 */
public final class Operation implements Mode {
    private final String title;
    private final LevelSequence levelSequence;

    public Operation(String title, LevelSequence levelSequence) {
        this.title = title;
        this.levelSequence = levelSequence;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public LevelSequence getLevelSequence() {
        return levelSequence;
    }
}
