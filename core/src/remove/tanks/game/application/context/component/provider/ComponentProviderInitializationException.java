package remove.tanks.game.application.context.component.provider;

/**
 * @author Mateusz Długosz
 */
public final class ComponentProviderInitializationException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot initialize component provider.";

    public ComponentProviderInitializationException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
