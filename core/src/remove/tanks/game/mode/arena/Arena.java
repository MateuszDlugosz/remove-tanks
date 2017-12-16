package remove.tanks.game.mode.arena;

import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.mode.GameMode;

/**
 * @author Mateusz Długosz
 */
public final class Arena implements GameMode {
    private final String title;
    private final LevelSequence levelSequence;

    public Arena(String title, LevelSequence levelSequence) {
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
