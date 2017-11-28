package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create event from prototype %s.";

    public EventCreateException(EventPrototype prototype) {
        super(String.format(MESSAGE_TEMPLATE, prototype.toString()));
    }
}
