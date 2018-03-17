package remove.tanks.game.profile.achievement;

/**
 * @author Mateusz Długosz
 */
public final class AchievementStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create achievement storage.";

    public AchievementStorageCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
