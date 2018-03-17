package remove.tanks.game.asset.parameter;

/**
 * @author Mateusz Długosz
 */
public final class ParametersCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create asset loader parameter from prefab %s.";

    public ParametersCreateException(ParametersPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
