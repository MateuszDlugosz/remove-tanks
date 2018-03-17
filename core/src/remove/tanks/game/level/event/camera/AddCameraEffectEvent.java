package remove.tanks.game.level.event.camera;

import remove.tanks.game.graphics.camera.effect.CameraEffect;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEvent implements Event {
    private final CameraEffect cameraEffect;

    public AddCameraEffectEvent(CameraEffect cameraEffect) {
        this.cameraEffect = cameraEffect;
    }

    public CameraEffect getCameraEffect() {
        return cameraEffect;
    }
}
