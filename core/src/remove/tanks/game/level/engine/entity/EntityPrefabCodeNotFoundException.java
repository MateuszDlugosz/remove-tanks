package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabCodeNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity prefab code %s not found.";

    public EntityPrefabCodeNotFoundException(String code) {
        super(String.format(MESSAGE_TEMPLATE, code));
    }
}
