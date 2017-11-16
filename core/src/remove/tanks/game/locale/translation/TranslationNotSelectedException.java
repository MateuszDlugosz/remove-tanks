package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class TranslationNotSelectedException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Translation not selected.";

    public TranslationNotSelectedException() {
        super(MESSAGE_TEMPLATE);
    }
}
