package remove.tanks.game.level.utility.stage.broker;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create message bar from prefab %s.";

    public MessageBarCreateException(MessageBarPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
