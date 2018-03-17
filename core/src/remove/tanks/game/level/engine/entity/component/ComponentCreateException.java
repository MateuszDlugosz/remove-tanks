package remove.tanks.game.level.engine.entity.component;

/**
 * @author Mateusz Długosz
 */
public final class ComponentCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create entity component from prefab %s.";

    public ComponentCreateException(ComponentPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
