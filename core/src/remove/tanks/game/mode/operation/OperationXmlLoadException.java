package remove.tanks.game.mode.operation;

/**
 * @author Mateusz Długosz
 */
public final class OperationXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load arena from file %s.";

    public OperationXmlLoadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
