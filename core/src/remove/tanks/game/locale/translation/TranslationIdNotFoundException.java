package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationIdNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Translation id %s not found.";

    public TranslationIdNotFoundException(String id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
