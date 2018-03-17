package remove.tanks.game.application.context.component.provider;

/**
 * @author Mateusz Długosz
 */
public final class ComponentSupplierInitializationException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot initialize component supplier.";

    public ComponentSupplierInitializationException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
