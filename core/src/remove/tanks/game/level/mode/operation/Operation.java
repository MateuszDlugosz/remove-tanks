package remove.tanks.game.level.mode.operation;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.mode.Mode;

/**
 * @author Mateusz Długosz
 */
public final class Operation implements Mode {
    private final String title;
    private final Sprite sprite;
    private final LevelSequence levelSequence;

    public Operation(String title, Sprite sprite, LevelSequence levelSequence) {
        this.title = title;
        this.sprite = sprite;
        this.levelSequence = levelSequence;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public LevelSequence getLevelSequence() {
        return levelSequence;
    }
}
