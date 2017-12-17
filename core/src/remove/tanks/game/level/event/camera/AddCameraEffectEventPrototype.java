package remove.tanks.game.level.event.camera;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.camera.effect.CameraEffectPrototype;
import remove.tanks.game.level.event.EventPrototype;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventPrototype implements EventPrototype {
    private final CameraEffectPrototype cameraEffectPrototype;

    public AddCameraEffectEventPrototype(CameraEffectPrototype cameraEffectPrototype) {
        this.cameraEffectPrototype = cameraEffectPrototype;
    }

    public CameraEffectPrototype getCameraEffectPrototype() {
        return cameraEffectPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cameraEffectPrototype", cameraEffectPrototype)
                .toString();
    }
}
