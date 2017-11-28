package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create event from prototype %s.";

    public EventCreateException(EventPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype.toString()), cause);
    }
}
