package remove.tanks.game.profile.achievement;

import remove.tanks.game.profile.Profile;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AchievementAvailabilityChecker {
    public Set<AchievementType> checkNewAchievementsAvailability(Profile profile) {
        try {
            return Arrays.stream(AchievementType.values())
                    .filter(v -> profile.getProperties()
                            .getInt(v.getDependentProperty().getName()) >= v.getRequiredPropertyValue())
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            throw new AchievementAvailabilityCheckException(e);
        }
    }
}
