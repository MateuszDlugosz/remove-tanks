package remove.tanks.game.level.engine.system.camera;

import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackSystemFactory implements SubEntitySystemFactory<CameraTrackSystem, CameraTrackSystemPrefab> {
    @Override
    public CameraTrackSystem createEntitySystem(CameraTrackSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new CameraTrackSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<CameraTrackSystemPrefab> getFactoryType() {
        return CameraTrackSystemPrefab.class;
    }
}
