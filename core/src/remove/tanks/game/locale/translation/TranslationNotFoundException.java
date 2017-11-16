package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Translation '%s' not found.";

    public TranslationNotFoundException(String id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
