package remove.tanks.game.level.mode.arena;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class ArenaPrefab extends Prefab {
    private final String title;
    private final int waves;
    private final SpritePrefab spritePrefab;
    private final LevelSequence levelSequence;

    public ArenaPrefab(String title, int waves, SpritePrefab spritePrefab, LevelSequence levelSequence) {
        this.title = title;
        this.waves = waves;
        this.spritePrefab = spritePrefab;
        this.levelSequence = levelSequence;
    }

    public String getTitle() {
        return title;
    }

    public int getWaves() {
        return waves;
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
                .add("waves", waves)
                .add("spritePrefab", spritePrefab)
                .add("levelSequence", levelSequence)
                .toString();
    }
}
