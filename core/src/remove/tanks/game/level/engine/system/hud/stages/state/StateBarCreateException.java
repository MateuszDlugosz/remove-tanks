package remove.tanks.game.level.engine.system.hud.stages.state;

/**
 * @author Mateusz Długosz
 */
public final class StateBarCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create state bar from prototype %s.";

    public StateBarCreateException(StateBarPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
