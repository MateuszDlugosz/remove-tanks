package remove.tanks.game.level.engine.system;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create entity system from prototype %s.";

    public EntitySystemCreateException(EntitySystemPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
