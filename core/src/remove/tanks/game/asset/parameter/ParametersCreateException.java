package remove.tanks.game.asset.parameter;

/**
 * @author Mateusz Długosz
 */
public final class ParametersCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create asset loader parameter from prototype %s.";

    public ParametersCreateException(ParametersPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
