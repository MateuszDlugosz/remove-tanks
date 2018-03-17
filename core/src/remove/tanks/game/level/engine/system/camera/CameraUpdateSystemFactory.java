package remove.tanks.game.level.engine.system.camera;

import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public final class CameraUpdateSystemFactory implements SubEntitySystemFactory<CameraUpdateSystem, CameraUpdateSystemPrefab> {
    @Override
    public CameraUpdateSystem createEntitySystem(CameraUpdateSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new CameraUpdateSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class),
                    registry.getResource(ResourceType.TiledMapBoundaryResource, Boundary.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<CameraUpdateSystemPrefab> getFactoryType() {
        return CameraUpdateSystemPrefab.class;
    }
}
