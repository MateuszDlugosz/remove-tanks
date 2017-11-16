package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public final class EntryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entry of '%s' key not found.";

    public EntryNotFoundException(String key) {
        super(String.format(MESSAGE_TEMPLATE, key));
    }
}
