package remove.tanks.game.application.context;

/**
 * @author Mateusz Długosz
 */
public final class ContextInitializationException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot initialize context.";

    public ContextInitializationException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
