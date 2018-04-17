package remove.tanks.game.level.mode.operation;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class OperationPrefab extends Prefab {
    private final String title;
    private final SpritePrefab spritePrefab;
    private final LevelSequence levelSequence;

    public OperationPrefab(String title, SpritePrefab spritePrefab, LevelSequence levelSequence) {
        this.title = title;
        this.spritePrefab = spritePrefab;
        this.levelSequence = levelSequence;
    }

    public String getTitle() {
        return title;
    }

    public SpritePrefab getSpritePrefab() {
        return spritePrefab;
    }

    public LevelSequence getLevelSequence() {
        return levelSequence;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("spritePrefab", spritePrefab)
                .add("levelSequence", levelSequence)
                .toString();
    }
}
