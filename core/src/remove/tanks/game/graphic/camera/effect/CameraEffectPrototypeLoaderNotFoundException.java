package remove.tanks.game.graphic.camera.effect;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectPrototypeLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Camera effect loader of %s not found.";

    public CameraEffectPrototypeLoaderNotFoundException(CameraEffectType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
