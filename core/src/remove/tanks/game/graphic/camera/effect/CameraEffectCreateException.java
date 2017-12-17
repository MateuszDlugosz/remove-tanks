package remove.tanks.game.graphic.camera.effect;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create camera effect from prototype %s.";

    public CameraEffectCreateException(CameraEffectPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
