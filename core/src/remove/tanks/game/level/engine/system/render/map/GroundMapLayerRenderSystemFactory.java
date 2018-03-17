package remove.tanks.game.level.engine.system.render.map;

import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class GroundMapLayerRenderSystemFactory implements SubEntitySystemFactory<GroundMapLayerRenderSystem, GroundMapLayerRenderSystemPrefab> {
    @Override
    public GroundMapLayerRenderSystem createEntitySystem(GroundMapLayerRenderSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new GroundMapLayerRenderSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.TiledMapRendererResource, TiledMapRenderer.class),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<GroundMapLayerRenderSystemPrefab> getFactoryType() {
        return GroundMapLayerRenderSystemPrefab.class;
    }
}
