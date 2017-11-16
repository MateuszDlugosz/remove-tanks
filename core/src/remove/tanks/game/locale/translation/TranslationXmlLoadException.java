package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load translation from file %s.";

    public TranslationXmlLoadException(String filename, Throwable cause) {
        super(filename, cause);
    }
}
