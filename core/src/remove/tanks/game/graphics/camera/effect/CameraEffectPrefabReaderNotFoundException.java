package remove.tanks.game.graphics.camera.effect;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Camera effect reader of %s not found.";

    public CameraEffectPrefabReaderNotFoundException(CameraEffectType cameraEffectType) {
        super(String.format(MESSAGE_TEMPLATE, cameraEffectType));
    }
}
