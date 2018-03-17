package remove.tanks.game.level.utility.stage.broker.message;

/**
 * @author Mateusz Długosz
 */
public final class MessageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create message from prefab %s.";

    public MessageCreateException(MessagePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
