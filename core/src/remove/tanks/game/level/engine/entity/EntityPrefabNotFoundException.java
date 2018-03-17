package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabNotFoundException extends RuntimeException {
    private static final  String MESSAGE_TEMPLATE = "Entity prefab %s not found.";

    public EntityPrefabNotFoundException(String code) {
        super(String.format(MESSAGE_TEMPLATE, code));
    }
}
