package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventPrototypeXmlLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Event prototype xml loader of %s event not found.";

    public EventPrototypeXmlLoaderNotFoundException(String type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
