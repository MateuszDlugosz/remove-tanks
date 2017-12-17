package remove.tanks.game.graphic.camera.effect.shake;

import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.graphic.camera.effect.CameraEffect;
import remove.tanks.game.utility.time.Timer;

import java.util.Random;

/**
 * @author Mateusz Długosz
 */
public final class ShakeCameraEffect implements CameraEffect {
    private final Timer timer;
    private final Random random;
    private final float power;
    private float currentPower;

    public ShakeCameraEffect(Timer timer, Random random, float power) {
        this.timer = timer;
        this.random = random;
        this.power = power;
        this.currentPower = 0;
    }

    @Override
    public boolean isCompleted() {
        return timer.isCompleted();
    }

    @Override
    public void update(float delta, Game2DCamera camera) {
        if (!timer.isCompleted()) {
            currentPower = computeCurrentPower();
            camera.getCamera().position.x = randCameraPosition();
            camera.getCamera().position.y = randCameraPosition();
            timer.update(delta);
        }
    }

    private float computeCurrentPower() {
        return power * ((timer.getCompletionTime() - timer.getTime()) / timer.getCompletionTime());
    }

    private float randCameraPosition() {
        return (random.nextFloat() - 0.5f) * 2 * currentPower;
    }
}
