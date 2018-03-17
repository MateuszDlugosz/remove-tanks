package remove.tanks.game.graphics.camera.effect;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Camera effect factory of %s prefab not found.";

    public CameraEffectFactoryNotFoundException(Class<? extends CameraEffectPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
