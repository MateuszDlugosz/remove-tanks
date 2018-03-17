package remove.tanks.game.graphics.camera.effect;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create camera effect from prefab %s.";

    public CameraEffectCreateException(CameraEffectPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
