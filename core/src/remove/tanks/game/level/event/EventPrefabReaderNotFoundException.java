package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EventPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Reader of prefab type %s not found.";

    public EventPrefabReaderNotFoundException(EventType eventType) {
        super(String.format(MESSAGE_TEMPLATE, eventType));
    }
}
