package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read translation from file %s.";

    public TranslationXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
