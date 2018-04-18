package remove.tanks.game.graphics.camera.effect.rotate;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RotateCameraEffectPrefab extends CameraEffectPrefab {
    private final float rotationSpeed;
    private final int numberOfRotations;

    public RotateCameraEffectPrefab(float rotationSpeed, int numberOfRotations) {
        this.rotationSpeed = rotationSpeed;
        this.numberOfRotations = numberOfRotations;
    }

    public float getRotationSpeed() {
        return rotationSpeed;
    }

    public int getNumberOfRotations() {
        return numberOfRotations;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("rotationSpeed", rotationSpeed)
                .add("numberOfRotations", numberOfRotations)
                .toString();
    }
}
