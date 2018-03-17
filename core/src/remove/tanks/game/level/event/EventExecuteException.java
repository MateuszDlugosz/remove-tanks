package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventExecuteException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot execute level event %s.";

    public EventExecuteException(Event event, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, event), cause);
    }
}
