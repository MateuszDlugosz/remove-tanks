package remove.tanks.game.level.mode.campaign;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefab extends Prefab {
    private final String title;
    private final LevelSequence levelSequence;

    public CampaignPrefab(String title, LevelSequence levelSequence) {
        this.title = title;
        this.levelSequence = levelSequence;
    }

    public String getTitle() {
        return title;
    }

    public LevelSequence getLevelSequence() {
        return levelSequence;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("levelSequence", levelSequence)
                .toString();
    }
}
