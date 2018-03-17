package remove.tanks.game.level.engine.entity.component;

/**
 * @author Mateusz Długosz
 */
public final class ComponentPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Component prefab reader of %s type, not found.";

    public ComponentPrefabReaderNotFoundException(ComponentType componentType) {
        super(String.format(MESSAGE_TEMPLATE, componentType));
    }
}
