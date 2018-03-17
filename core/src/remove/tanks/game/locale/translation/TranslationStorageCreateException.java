package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create translation storage.";

    public TranslationStorageCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
