package remove.tanks.game.graphic.camera.effect.shake;

import remove.tanks.game.graphic.camera.effect.RegistrableCameraEffectFactory;
import remove.tanks.game.utility.time.Timer;

import java.util.Random;

/**
 * @author Mateusz Długosz
 */
public final class ShakeCameraEffectFactory
        implements RegistrableCameraEffectFactory<ShakeCameraEffect, ShakeCameraEffectPrototype>
{
    private final Random random;

    public ShakeCameraEffectFactory(Random random) {
        this.random = random;
    }

    @Override
    public ShakeCameraEffect createCameraEffect(ShakeCameraEffectPrototype prototype) {
        return new ShakeCameraEffect(
                createTimer(prototype.getTime()),
                random,
                prototype.getPower()
        );
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    @Override
    public Class<ShakeCameraEffectPrototype> getFactoryType() {
        return ShakeCameraEffectPrototype.class;
    }
}
