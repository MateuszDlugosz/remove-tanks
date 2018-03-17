package remove.tanks.game.profile;

/**
 * @author Mateusz Długosz
 */
public final class ProfileXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read profile from file %s.";

    public ProfileXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
