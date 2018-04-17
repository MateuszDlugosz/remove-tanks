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
public final class FogOfWarMapLayerRenderSystemFactory implements SubEntitySystemFactory<FogOfWarMapLayerRenderSystem, FogOfWarMapLayerRenderSystemPrefab> {
    @Override
    public FogOfWarMapLayerRenderSystem createEntitySystem(FogOfWarMapLayerRenderSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new FogOfWarMapLayerRenderSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.TiledMapRendererResource, TiledMapRenderer.class),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<FogOfWarMapLayerRenderSystemPrefab> getFactoryType() {
        return FogOfWarMapLayerRenderSystemPrefab.class;
    }
}
