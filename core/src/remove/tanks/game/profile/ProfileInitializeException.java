package remove.tanks.game.profile;

/**
 * @author Mateusz Długosz
 */
public final class ProfileInitializeException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot initialize profile from empty profile.";

    public ProfileInitializeException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
