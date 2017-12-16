package remove.tanks.game.mode.operation;

import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.mode.GameMode;

/**
 * @author Mateusz Długosz
 */
public final class Operation implements GameMode {
    private final String title;
    private final LevelSequence levelSequence;

    public Operation(String title, LevelSequence levelSequence) {
        this.title = title;
        this.levelSequence = levelSequence;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public LevelSequence getLevelSequence() {
        return levelSequence;
    }
}
