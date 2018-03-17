package remove.tanks.game.graphics.camera.effect;

/**
 * @author Mateusz Długosz
 */
public interface SubCameraEffectFactory<T extends CameraEffect, U extends CameraEffectPrefab> {
    T createCameraEffect(U prefab);
    Class<U> getFactoryType();
}
