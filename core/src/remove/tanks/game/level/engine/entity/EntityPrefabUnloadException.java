package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabUnloadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot unload entity prefab of code %s.";

    public EntityPrefabUnloadException(String code, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, code), cause);
    }
}
