package remove.tanks.game.level.mode.operation;

/**
 * @author Mateusz Długosz
 */
public final class OperationCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create operation from prefab %s.";

    public OperationCreateException(OperationPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
