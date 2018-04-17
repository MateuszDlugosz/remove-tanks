package remove.tanks.game.graphics.camera.effect.rotate;

import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.graphics.camera.effect.CameraEffect;

/**
 * @author Mateusz Długosz
 */
public final class ContinuousRotateCameraEffect implements CameraEffect {
    private final float rotationSpeed;

    public ContinuousRotateCameraEffect(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    public void update(float delta, Game2DCamera camera) {
        camera.rotate(-rotationSpeed);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
