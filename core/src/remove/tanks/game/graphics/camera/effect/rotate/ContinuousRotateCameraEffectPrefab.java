package remove.tanks.game.graphics.camera.effect.rotate;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ContinuousRotateCameraEffectPrefab extends CameraEffectPrefab {
    private final float rotationSpeed;

    public ContinuousRotateCameraEffectPrefab(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public float getRotationSpeed() {
        return rotationSpeed;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("rotationSpeed", rotationSpeed)
                .toString();
    }
}
