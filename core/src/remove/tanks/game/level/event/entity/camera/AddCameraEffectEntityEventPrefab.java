package remove.tanks.game.level.event.entity.camera;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;
import remove.tanks.game.level.event.EntityEventPrefab;

public final class AddCameraEffectEntityEventPrefab extends EntityEventPrefab {
    private final CameraEffectPrefab cameraEffectPrefab;

    public AddCameraEffectEntityEventPrefab(CameraEffectPrefab cameraEffectPrefab) {
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
