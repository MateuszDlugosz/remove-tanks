package remove.tanks.game.locale;

/**
 * @author Mateusz Długosz
 */
public final class LocaleCreateException extends RuntimeException{
    private static final String MESSAGE_TEMPLATE = "Cannot create locale.";

    public LocaleCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
