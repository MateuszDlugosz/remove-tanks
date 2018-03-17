package remove.tanks.game.profile.achievement;

import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AchievementStorageFactory {
    private final AchievementFactory achievementFactory;

    public AchievementStorageFactory(AchievementFactory achievementFactory) {
        this.achievementFactory = achievementFactory;
    }

    public AchievementStorage createAchievementStorage(AchievementPrefabRepository repository, AssetStorage assetStorage, Scale scale) {
        try {
            return new AchievementStorage(createAchievementMap(repository, assetStorage, scale));
        } catch (Exception e) {
            throw new AchievementStorageCreateException(e);
        }
    }

    private Map<AchievementType, Achievement> createAchievementMap(AchievementPrefabRepository repository, AssetStorage assetStorage, Scale scale) {
        return Arrays.stream(AchievementType.values())
                .map(t -> achievementFactory.createAchievement(repository.getAchievementPrefab(t), assetStorage, scale))
                .collect(Collectors.toMap(
                        Achievement::getAchievementType,
                        a -> a
                ));
    }
}
