package remove.tanks.game.level.engine.entity.component;

/**
 * @author Mateusz Długosz
 */
public final class ComponentPrototypeLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Component prototype loader of %s type, not found.";

    public ComponentPrototypeLoaderNotFoundException(ComponentType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
