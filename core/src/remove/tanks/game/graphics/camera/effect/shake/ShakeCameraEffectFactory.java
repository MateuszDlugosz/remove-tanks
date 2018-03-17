package remove.tanks.game.graphics.camera.effect.shake;

import remove.tanks.game.graphics.camera.effect.CameraEffectCreateException;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectFactory;
import remove.tanks.game.utility.time.Timer;

import java.util.Random;

/**
 * @author Mateusz Długosz
 */
public final class ShakeCameraEffectFactory implements SubCameraEffectFactory<ShakeCameraEffect, ShakeCameraEffectPrefab> {
    private final Random random;

    public ShakeCameraEffectFactory(Random random) {
        this.random = random;
    }

    @Override
    public ShakeCameraEffect createCameraEffect(ShakeCameraEffectPrefab prefab) {
        try {
            return new ShakeCameraEffect(
                    createTimer(prefab.getTime()),
                    random,
                    prefab.getPower()
            );
        } catch (Exception e) {
            throw new CameraEffectCreateException(prefab, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    @Override
    public Class<ShakeCameraEffectPrefab> getFactoryType() {
        return ShakeCameraEffectPrefab.class;
    }
}
