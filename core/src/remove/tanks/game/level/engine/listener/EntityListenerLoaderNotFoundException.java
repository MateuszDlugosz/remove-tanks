package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity listener prototype loader of %s not found.";

    public EntityListenerLoaderNotFoundException(ListenerType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
