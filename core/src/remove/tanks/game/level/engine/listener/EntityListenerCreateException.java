package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create entity listener from prefab %s.";

    public EntityListenerCreateException(EntityListenerPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
