package remove.tanks.game.level.event.camera;

import remove.tanks.game.graphics.camera.effect.CameraEffect;
import remove.tanks.game.graphics.camera.effect.CameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;
import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventFactory implements SubEventFactory<AddCameraEffectEvent, AddCameraEffectEventPrefab> {
    private final CameraEffectFactory cameraEffectFactory;

    public AddCameraEffectEventFactory(CameraEffectFactory cameraEffectFactory) {
        this.cameraEffectFactory = cameraEffectFactory;
    }

    @Override
    public AddCameraEffectEvent createEvent(AddCameraEffectEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new AddCameraEffectEvent(createCameraEffect(prefab.getCameraEffectPrefab()));
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    private CameraEffect createCameraEffect(CameraEffectPrefab prefab) {
        return cameraEffectFactory.createCameraEffect(prefab);
    }

    @Override
    public Class<AddCameraEffectEventPrefab> getFactoryType() {
        return AddCameraEffectEventPrefab.class;
    }
}
