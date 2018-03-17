package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Factory of event type %s not found.";

    public EventFactoryNotFoundException(Class<? extends EventPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
