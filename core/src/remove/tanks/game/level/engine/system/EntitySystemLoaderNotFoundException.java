package remove.tanks.game.level.engine.system;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity system loader of %s not found.";

    public EntitySystemLoaderNotFoundException(SystemType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
