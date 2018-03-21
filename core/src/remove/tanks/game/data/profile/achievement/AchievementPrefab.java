package remove.tanks.game.data.profile.achievement;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class AchievementPrefab extends Prefab {
    private final AchievementType achievementType;
    private final SpritePrefab spritePrefab;

    public AchievementPrefab(AchievementType achievementType, SpritePrefab spritePrefab) {
        this.achievementType = achievementType;
        this.spritePrefab = spritePrefab;
    }

    public AchievementType getAchievementType() {
        return achievementType;
    }

    public SpritePrefab getSpritePrefab() {
        return spritePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("achievementType", achievementType)
                .add("spritePrefab", spritePrefab)
                .toString();
    }
}
