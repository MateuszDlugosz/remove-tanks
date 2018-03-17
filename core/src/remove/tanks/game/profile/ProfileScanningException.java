package remove.tanks.game.profile;

/**
 * @author Mateusz Długosz
 */
public final class ProfileScanningException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Profile scanning exception.";

    public ProfileScanningException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
