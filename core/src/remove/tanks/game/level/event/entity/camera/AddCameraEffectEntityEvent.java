package remove.tanks.game.level.event.entity.camera;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.graphics.camera.effect.CameraEffect;
import remove.tanks.game.level.event.EntityEvent;

public final class AddCameraEffectEntityEvent implements EntityEvent {
    private final Entity entity;
    private final CameraEffect cameraEffect;

    public AddCameraEffectEntityEvent(Entity entity, CameraEffect cameraEffect) {
        this.entity = entity;
        this.cameraEffect = cameraEffect;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public CameraEffect getCameraEffect() {
        return cameraEffect;
    }
}
