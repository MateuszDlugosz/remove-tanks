package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create entity prefab storage.";

    public EntityPrefabStorageCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
