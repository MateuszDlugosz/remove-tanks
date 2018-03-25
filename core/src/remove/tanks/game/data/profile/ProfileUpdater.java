package remove.tanks.game.data.profile;

import remove.tanks.game.data.profile.achievement.AchievementAvailabilityChecker;
import remove.tanks.game.data.profile.achievement.AchievementType;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.utility.properties.Properties;

import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class ProfileUpdater {
    private final AchievementAvailabilityChecker achievementAvailabilityChecker;

    public ProfileUpdater(AchievementAvailabilityChecker achievementAvailabilityChecker) {
        this.achievementAvailabilityChecker = achievementAvailabilityChecker;
    }

    public Profile updateProfile(Profile profile, Properties levelProperties) {
        try {
            return new Profile(
                    updateProperties(profile.getProperties(), levelProperties),
                    updateAchievements(profile)
            );
        } catch (Exception e) {
            throw new ProfileUpdateException(e);
        }
    }

    private Set<AchievementType> updateAchievements(Profile profile) {
        return achievementAvailabilityChecker.checkNewAchievementsAvailability(profile);
    }

    private Properties updateProperties(Properties profileProperties, Properties levelProperties) {
        profileProperties.putInt(ProfileProperty.ProfileDestroyedEnemies.getName(),
                profileProperties.getInt(ProfileProperty.ProfileDestroyedEnemies.getName())
                + levelProperties.getInt(LevelProperty.LevelEnemiesDestroyed.getName(), 0));
        profileProperties.putInt(ProfileProperty.ProfilePoints.getName(),
                profileProperties.getInt(ProfileProperty.ProfilePoints.getName())
                        + levelProperties.getInt(LevelProperty.LevelPoints.getName(), 0));
        return profileProperties;
    }
}
