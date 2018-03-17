package remove.tanks.game.profile.achievement;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AchievementStorage {
    private final Map<AchievementType, Achievement> achievements;

    AchievementStorage(Map<AchievementType, Achievement> achievements) {
        this.achievements = achievements;
    }

    public Achievement getAchievement(AchievementType achievementType) {
        if (!achievements.containsKey(achievementType)) {
            throw new AchievementNotFoundException(achievementType);
        }
        return achievements.get(achievementType);
    }
}
