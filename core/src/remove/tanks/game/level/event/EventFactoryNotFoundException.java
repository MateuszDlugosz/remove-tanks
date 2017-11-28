package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Factory of %s event not found.";

    public EventFactoryNotFoundException(String type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
