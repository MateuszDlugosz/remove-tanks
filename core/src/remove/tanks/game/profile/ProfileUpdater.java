package remove.tanks.game.profile;

import remove.tanks.game.profile.achievement.AchievementAvailabilityChecker;
import remove.tanks.game.profile.achievement.AchievementType;

import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class ProfileUpdater {
    private final AchievementAvailabilityChecker achievementAvailabilityChecker;

    public ProfileUpdater(AchievementAvailabilityChecker achievementAvailabilityChecker) {
        this.achievementAvailabilityChecker = achievementAvailabilityChecker;
    }

    public Profile updateProfile(Profile profile) {
        try {
            return new Profile(
                    profile.getProperties(),
                    getAvailableAchievementTypes(profile)
            );
        } catch (Exception e) {
            throw new ProfileUpdateException(e);
        }
    }

    private Set<AchievementType> getAvailableAchievementTypes(Profile profile) {
        return achievementAvailabilityChecker.checkNewAchievementsAvailability(profile);
    }
}
