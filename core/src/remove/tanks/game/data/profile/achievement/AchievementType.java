package remove.tanks.game.data.profile.achievement;

import remove.tanks.game.data.profile.ProfileProperty;

/**
 * @author Mateusz Długosz
 */
public enum AchievementType {
    EnemiesDestroyed10(ProfileProperty.ProfileDestroyedEnemies, 10),
    EnemiesDestroyed25(ProfileProperty.ProfileDestroyedEnemies, 25);

    private final ProfileProperty dependentProperty;
    private final int requiredPropertyValue;

    AchievementType(ProfileProperty dependentProperty, int requiredPropertyValue) {
        this.dependentProperty = dependentProperty;
        this.requiredPropertyValue = requiredPropertyValue;
    }

    public ProfileProperty getDependentProperty() {
        return dependentProperty;
    }

    public int getRequiredPropertyValue() {
        return requiredPropertyValue;
    }
}
