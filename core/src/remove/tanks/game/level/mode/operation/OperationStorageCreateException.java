package remove.tanks.game.level.mode.operation;

/**
 * @author Mateusz Długosz
 */
public final class OperationStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create operation storage.";

    public OperationStorageCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
