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
public final class CameraTrackSystemFactory implements SubEntitySystemFactory<CameraTrackSystem, CameraTrackSystemPrefab> {
    @Override
    public CameraTrackSystem createEntitySystem(CameraTrackSystemPrefab prefab, ResourceRegistry registry) {
        try {
            Boundary boundary = registry.getResource(ResourceType.TiledMapBoundaryResource, Boundary.class);
            Game2DCamera camera = registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class);

            lockCameraX(boundary, camera);
            lockCameraY(boundary, camera);

            return new CameraTrackSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class),
                    registry.getResource(ResourceType.TiledMapBoundaryResource, Boundary.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private void lockCameraX(Boundary boundary, Game2DCamera camera) {
        if (camera.getCameraBoundaries().getWidth() >= boundary.getWidth()) {
            camera.lockX(boundary.getCenterPosition().getX());
        }
    }

    private void lockCameraY(Boundary boundary, Game2DCamera camera) {
        if (camera.getCameraBoundaries().getHeight() >= boundary.getHeight()) {
            camera.lockY(boundary.getCenterPosition().getY());
        }
    }

    @Override
    public Class<CameraTrackSystemPrefab> getFactoryType() {
        return CameraTrackSystemPrefab.class;
    }
}
