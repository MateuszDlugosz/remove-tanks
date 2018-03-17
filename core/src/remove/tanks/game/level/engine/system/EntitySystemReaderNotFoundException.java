package remove.tanks.game.level.engine.system;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity system reader of %s not found.";

    public EntitySystemReaderNotFoundException(SystemType systemType) {
        super(String.format(MESSAGE_TEMPLATE, systemType));
    }
}
