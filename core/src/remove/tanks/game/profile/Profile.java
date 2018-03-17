package remove.tanks.game.profile;

import remove.tanks.game.profile.achievement.AchievementType;
import remove.tanks.game.utility.properties.Properties;

import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class Profile {
    private final Properties properties;
    private final Set<AchievementType> achievementTypes;

    public Profile(Properties properties, Set<AchievementType> achievementTypes) {
        this.properties = properties;
        this.achievementTypes = achievementTypes;
    }

    public Properties getProperties() {
        return properties;
    }

    public Set<AchievementType> getAchievementTypes() {
        return achievementTypes;
    }
}
