package remove.tanks.game.level.engine.listener;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create entity listener from prototype %s.";

    public EntityListenerCreateException(EntityListenerPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
