package remove.tanks.game.level.engine.system;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity system factory of %s not found.";

    public EntitySystemFactoryNotFoundException(Class<? extends EntitySystemPrototype> type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
