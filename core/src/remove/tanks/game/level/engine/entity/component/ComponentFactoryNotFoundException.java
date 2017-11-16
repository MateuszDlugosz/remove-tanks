package remove.tanks.game.level.engine.entity.component;

/**
 * @author Mateusz Długosz
 */
public final class ComponentFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Component factory of %s not found.";

    public ComponentFactoryNotFoundException(String type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
