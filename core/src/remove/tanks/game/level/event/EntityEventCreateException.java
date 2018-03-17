package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EntityEventCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create entity event from prefab %s.";

    public EntityEventCreateException(EntityEventPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
