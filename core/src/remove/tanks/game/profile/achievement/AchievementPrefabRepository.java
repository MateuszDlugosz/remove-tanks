package remove.tanks.game.profile.achievement;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AchievementPrefabRepository {
    private final Map<AchievementType, AchievementPrefab> achievementPrefabs;

    AchievementPrefabRepository(Map<AchievementType, AchievementPrefab> achievementPrefabs) {
        this.achievementPrefabs = achievementPrefabs;
    }

    public AchievementPrefab getAchievementPrefab(AchievementType achievementType) {
        if (!achievementPrefabs.containsKey(achievementType)) {
            throw new AchievementPrefabNotFoundException(achievementType);
        }
        return achievementPrefabs.get(achievementType);
    }
}
