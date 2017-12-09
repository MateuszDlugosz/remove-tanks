package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationXmlLoadException extends RuntimeException {
    public TranslationXmlLoadException(String filename, Throwable cause) {
        super(filename, cause);
    }
}
