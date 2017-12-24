package remove.tanks.game.level.engine.system.camera;

import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackSystemFactory
        implements RegistrableEntitySystemFactory<CameraTrackSystem, CameraTrackSystemPrototype>
{

    @Override
    public CameraTrackSystem createEntitySystem(CameraTrackSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new CameraTrackSystem(
                    prototype.getPriority(),
                    resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<CameraTrackSystemPrototype> getFactoryType() {
        return CameraTrackSystemPrototype.class;
    }
}
