package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity listener factory of  %s not found.";

    public EntityListenerFactoryNotFoundException(Class<? extends EntityListenerPrototype> type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
