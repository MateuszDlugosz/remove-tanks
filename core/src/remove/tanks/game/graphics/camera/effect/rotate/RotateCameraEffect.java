package remove.tanks.game.graphics.camera.effect.rotate;

import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.graphics.camera.effect.CameraEffect;
import remove.tanks.game.utility.number.counter.Counter;

/**
 * @author Mateusz Długosz
 */
public final class RotateCameraEffect implements CameraEffect {
    private final float rotationSpeed;
    private float degreeCounter;
    private final Counter rotationsCounter;
    private final boolean clockwiseDirection;

    public RotateCameraEffect(float rotationSpeed, Counter rotationsCounter, boolean clockwiseDirection) {
        this.rotationSpeed = rotationSpeed;
        this.degreeCounter = 0;
        this.rotationsCounter = rotationsCounter;
        this.clockwiseDirection = clockwiseDirection;
    }

    @Override
    public void update(float delta, Game2DCamera camera) {
        if (!rotationsCounter.isComplete()) {
            if (degreeCounter >= 360) {
                degreeCounter -= 360;
                rotationsCounter.update();

                if (clockwiseDirection) {
                    camera.getCamera().rotate(rotationSpeed);
                } else {
                    camera.getCamera().rotate(-rotationSpeed);
                }
            } else {
                degreeCounter += rotationSpeed;
            }
        }
    }

    @Override
    public boolean isCompleted() {
        return rotationsCounter.isComplete();
    }
}
