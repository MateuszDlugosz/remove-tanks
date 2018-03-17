package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity cannot be created from prefab %s.";

    public EntityCreateException(EntityPrefab entityPrefab, Throwable throwable) {
        super(String.format(MESSAGE_TEMPLATE, entityPrefab), throwable);
    }
}
