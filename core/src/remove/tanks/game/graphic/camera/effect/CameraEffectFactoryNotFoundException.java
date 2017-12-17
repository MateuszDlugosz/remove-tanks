package remove.tanks.game.graphic.camera.effect;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Camera effect factory of %s prototype not found.";

    public CameraEffectFactoryNotFoundException(Class<? extends CameraEffectPrototype> prototypeClass) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClass));
    }
}
