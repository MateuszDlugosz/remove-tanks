package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.physics.world.renderer.WorldRenderer;

/**
 * @author Mateusz Długosz
 */
public final class WorldDebugRenderSystemFactory implements SubEntitySystemFactory<WorldDebugRenderSystem, WorldDebugRenderSystemPrefab> {
    private final WorldRenderer worldRenderer;

    public WorldDebugRenderSystemFactory(WorldRenderer worldRenderer) {
        this.worldRenderer = worldRenderer;
    }

    @Override
    public WorldDebugRenderSystem createEntitySystem(WorldDebugRenderSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new WorldDebugRenderSystem(
                    prefab.getPriority(),
                    worldRenderer,
                    registry.getResource(ResourceType.WorldResource, World.class),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class).getCamera()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<WorldDebugRenderSystemPrefab> getFactoryType() {
        return WorldDebugRenderSystemPrefab.class;
    }
}
