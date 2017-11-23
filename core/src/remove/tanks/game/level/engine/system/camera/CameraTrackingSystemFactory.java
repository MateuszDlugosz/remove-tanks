package remove.tanks.game.level.engine.system.camera;

import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackingSystemFactory
        implements RegistrableEntitySystemFactory<CameraTrackingSystem, CameraTrackingSystemPrototype>
{

    @Override
    public CameraTrackingSystem createEntitySystem(CameraTrackingSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new CameraTrackingSystem(
                prototype.getPriority(),
                resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class)
        );
    }

    @Override
    public Class<CameraTrackingSystemPrototype> getFactoryType() {
        return CameraTrackingSystemPrototype.class;
    }
}
