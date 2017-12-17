package remove.tanks.game.graphic.camera.effect;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableCameraEffectFactory<T extends CameraEffect, U extends CameraEffectPrototype> {
    T createCameraEffect(U prototype);
    Class<U> getFactoryType();
}
