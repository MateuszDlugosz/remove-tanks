package remove.tanks.game.profile;

/**
 * @author Mateusz Długosz
 */
public final class ProfileUpdateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot update profile.";

    public ProfileUpdateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
