package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationRepositoryXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read translation repository from file %s.";

    public TranslationRepositoryXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
