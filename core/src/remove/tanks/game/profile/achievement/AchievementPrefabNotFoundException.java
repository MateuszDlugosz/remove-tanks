package remove.tanks.game.profile.achievement;

/**
 * @author Mateusz Długosz
 */
public final class AchievementPrefabNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Achievement prefab of type %s not found.";

    public AchievementPrefabNotFoundException(AchievementType achievementType) {
        super(String.format(MESSAGE_TEMPLATE, achievementType));
    }
}
