package remove.tanks.game.level.event.camera;

import remove.tanks.game.graphic.camera.effect.CameraEffect;
import remove.tanks.game.graphic.camera.effect.CameraEffectFactory;
import remove.tanks.game.graphic.camera.effect.CameraEffectPrototype;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventFactory
        implements RegistrableEventFactory<AddCameraEffectEvent, AddCameraEffectEventPrototype>
{
    private final CameraEffectFactory cameraEffectFactory;

    public AddCameraEffectEventFactory(CameraEffectFactory cameraEffectFactory) {
        this.cameraEffectFactory = cameraEffectFactory;
    }

    @Override
    public AddCameraEffectEvent createEvent(AddCameraEffectEventPrototype prototype) {
        return new AddCameraEffectEvent(
                createCameraEffect(prototype.getCameraEffectPrototype())
        );
    }

    private CameraEffect createCameraEffect(CameraEffectPrototype prototype) {
        return cameraEffectFactory.createCameraEffect(prototype);
    }

    @Override
    public Class<AddCameraEffectEventPrototype> getFactoryType() {
        return AddCameraEffectEventPrototype.class;
    }
}