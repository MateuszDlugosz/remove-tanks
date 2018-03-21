package remove.tanks.game.data.profile;

/**
 * @author Mateusz Długosz
 */
public final class ProfileXmlWriteException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot write profile to xml string.";

    public ProfileXmlWriteException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
