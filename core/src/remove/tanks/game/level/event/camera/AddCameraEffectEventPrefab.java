package remove.tanks.game.level.event.camera;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventPrefab extends EventPrefab {
    private final CameraEffectPrefab cameraEffectPrefab;

    public AddCameraEffectEventPrefab(CameraEffectPrefab cameraEffectPrefab) {
        this.cameraEffectPrefab = cameraEffectPrefab;
    }

    public CameraEffectPrefab getCameraEffectPrefab() {
        return cameraEffectPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cameraEffectPrefab", cameraEffectPrefab)
                .toString();
    }
}
