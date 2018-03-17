package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity listener prefab reader of %s not found.";

    public EntityListenerReaderNotFoundException(ListenerType listenerType) {
        super(String.format(MESSAGE_TEMPLATE, listenerType));
    }
}