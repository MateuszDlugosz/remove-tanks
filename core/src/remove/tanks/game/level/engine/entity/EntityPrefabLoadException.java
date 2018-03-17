package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load entity prefab of code %s.";

    public EntityPrefabLoadException(String code, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, code), cause);
    }
}
