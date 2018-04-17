package remove.tanks.game.graphics.camera.effect.rotate;

import remove.tanks.game.graphics.camera.effect.CameraEffectCreateException;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectFactory;
import remove.tanks.game.utility.number.counter.Counter;

/**
 * @author Mateusz Długosz
 */
public final class RotateCameraEffectFactory implements SubCameraEffectFactory<RotateCameraEffect, RotateCameraEffectPrefab> {
    @Override
    public RotateCameraEffect createCameraEffect(RotateCameraEffectPrefab prefab) {
        try {
            return new RotateCameraEffect(
                    prefab.getRotationSpeed(),
                    createCounter(prefab.getNumberOfRotations()),
                    prefab.isClockwiseDirection()
            );
        } catch (Exception e) {
            throw new CameraEffectCreateException(prefab, e);
        }
    }

    private Counter createCounter(int numberOfRotations) {
        return new Counter(numberOfRotations);
    }

    @Override
    public Class<RotateCameraEffectPrefab> getFactoryType() {
        return RotateCameraEffectPrefab.class;
    }
}
