package remove.tanks.game.level.utility.stage.broker.printer;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create message printer from prefab %s.";

    public MessagePrinterCreateException(MessagePrinterPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
