package remove.tanks.game.graphics.camera.effect.rotate;

import remove.tanks.game.graphics.camera.effect.CameraEffectCreateException;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectFactory;

/**
 * @author Mateusz Długosz
 */
public final class ContinuousRotateCameraEffectFactory implements SubCameraEffectFactory<ContinuousRotateCameraEffect, ContinuousRotateCameraEffectPrefab> {
    @Override
    public ContinuousRotateCameraEffect createCameraEffect(ContinuousRotateCameraEffectPrefab prefab) {
        try {
            return new ContinuousRotateCameraEffect(prefab.getRotationSpeed());
        } catch (Exception e) {
            throw new CameraEffectCreateException(prefab, e);
        }
    }

    @Override
    public Class<ContinuousRotateCameraEffectPrefab> getFactoryType() {
        return ContinuousRotateCameraEffectPrefab.class;
    }
}
