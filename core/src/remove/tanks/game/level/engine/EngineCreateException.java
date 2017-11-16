package remove.tanks.game.level.engine;

/**
 * @author Mateusz Długosz
 */
public final class EngineCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create engine from prototype %s.";

    public EngineCreateException(EnginePrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
