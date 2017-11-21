package remove.tanks.game.level.engine.system.camera;

import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.boundary.Boundaries;

/**
 * @author Mateusz Długosz
 */
public final class CameraUpdateSystemFactory
        implements RegistrableEntitySystemFactory<CameraUpdateSystem, CameraUpdateSystemPrototype>
{
    private static final String FACTORY_TYPE = "CameraUpdateSystem";

    @Override
    public CameraUpdateSystem createEntitySystem(CameraUpdateSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new CameraUpdateSystem(
                resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class),
                resourceRegistry.getResource(LevelResource.TiledMapBoundaries.toString(), Boundaries.class),
                prototype.getPriority()
        );
    }

    @Override
    public Class<CameraUpdateSystemPrototype> getFactoryType() {
        return CameraUpdateSystemPrototype.class;
    }
}
