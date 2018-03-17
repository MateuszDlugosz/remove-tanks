package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create event from prefab %s.";

    public EventCreateException(EventPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
