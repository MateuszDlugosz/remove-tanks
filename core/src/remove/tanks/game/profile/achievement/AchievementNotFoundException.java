package remove.tanks.game.profile.achievement;

/**
 * @author Mateusz Długosz
 */
public final class AchievementNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Achievement of type %s not found.";

    public AchievementNotFoundException(AchievementType achievementType) {
        super(String.format(MESSAGE_TEMPLATE, achievementType));
    }
}
