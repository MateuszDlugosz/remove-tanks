package remove.tanks.game.mode.campaign;

import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.mode.GameMode;

/**
 * @author Mateusz Długosz
 */
public final class Campaign implements GameMode {
    private final String title;
    private final LevelSequence levelSequence;

    public Campaign(String title, LevelSequence levelSequence) {
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
