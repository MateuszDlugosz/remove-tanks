package remove.tanks.game.level.engine.system.camera;

import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectSystemFactory
        implements RegistrableEntitySystemFactory<CameraEffectSystem, CameraEffectSystemPrototype>
{
    @Override
    public CameraEffectSystem createEntitySystem(CameraEffectSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new CameraEffectSystem(
                prototype.getPriority(),
                resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class)
        );
    }

    @Override
    public Class<CameraEffectSystemPrototype> getFactoryType() {
        return CameraEffectSystemPrototype.class;
    }
}
