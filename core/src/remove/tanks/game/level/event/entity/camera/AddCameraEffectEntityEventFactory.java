package remove.tanks.game.level.event.entity.camera;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.graphics.camera.effect.CameraEffect;
import remove.tanks.game.graphics.camera.effect.CameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

public final class AddCameraEffectEntityEventFactory implements SubEntityEventFactory<AddCameraEffectEntityEvent, AddCameraEffectEntityEventPrefab> {
    private final CameraEffectFactory cameraEffectFactory;

    public AddCameraEffectEntityEventFactory(CameraEffectFactory cameraEffectFactory) {
        this.cameraEffectFactory = cameraEffectFactory;
    }

    @Override
    public AddCameraEffectEntityEvent createEntityEvent(AddCameraEffectEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AddCameraEffectEntityEvent(entity, createCameraEffect(prefab.getCameraEffectPrefab()));
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    private CameraEffect createCameraEffect(CameraEffectPrefab prefab) {
        return cameraEffectFactory.createCameraEffect(prefab);
    }

    @Override
    public Class<AddCameraEffectEntityEventPrefab> getFactoryType() {
        return AddCameraEffectEntityEventPrefab.class;
    }
}
