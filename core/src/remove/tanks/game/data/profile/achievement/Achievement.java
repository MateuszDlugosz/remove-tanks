package remove.tanks.game.data.profile.achievement;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author Mateusz Długosz
 */
public final class Achievement {
    private final AchievementType achievementType;
    private final Sprite sprite;

    public Achievement(AchievementType achievementType, Sprite sprite) {
        this.achievementType = achievementType;
        this.sprite = sprite;
    }

    public AchievementType getAchievementType() {
        return achievementType;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
