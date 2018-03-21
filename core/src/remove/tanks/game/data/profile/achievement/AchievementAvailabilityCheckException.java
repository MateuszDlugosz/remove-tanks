package remove.tanks.game.data.profile.achievement;

/**
 * @author Mateusz Długosz
 */
public final class AchievementAvailabilityCheckException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot check achievement availability.";

    public AchievementAvailabilityCheckException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
