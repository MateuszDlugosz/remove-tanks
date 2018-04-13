package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.mode.Mode;

/**
 * @author Mateusz Długosz
 */
public final class Arena implements Mode {
    private final String title;
    private final int waves;
    private final Sprite sprite;
    private final LevelSequence levelSequence;

    public Arena(String title, int waves, Sprite sprite, LevelSequence levelSequence) {
        this.title = title;
        this.waves = waves;
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

    public int getWaves() {
        return waves;
    }

    @Override
    public LevelSequence getLevelSequence() {
        return levelSequence;
    }
}
