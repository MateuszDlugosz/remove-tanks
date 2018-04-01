package remove.tanks.game.level.mode.operation;

/**
 * @author Mateusz Długosz
 */
public final class OperationNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Operation titled %s not found in storage.";

    public OperationNotFoundException(String title) {
        super(String.format(MESSAGE_TEMPLATE, title));
    }
}
