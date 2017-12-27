package remove.tanks.game.level.engine.system.hud.stages.broker.face;

/**
 * @author Mateusz Długosz
 */
public final class FaceCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create face from prototype %s.";

    public FaceCreateException(FacePrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
