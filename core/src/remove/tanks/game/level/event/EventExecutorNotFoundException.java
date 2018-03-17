package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventExecutorNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Event executor of %s not found.";

    public EventExecutorNotFoundException(Class<? extends Event> eventClass) {
        super(String.format(MESSAGE_TEMPLATE, eventClass));
    }
}
