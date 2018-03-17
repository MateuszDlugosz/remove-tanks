package remove.tanks.game.level.engine.system.world;

import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.physics.light.world.renderer.WorldLightRenderer;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightRenderSystemFactory implements SubEntitySystemFactory<WorldLightRenderSystem, WorldLightRenderSystemPrefab> {
    private final WorldLightRenderer worldLightRenderer;

    public WorldLightRenderSystemFactory(WorldLightRenderer worldLightRenderer) {
        this.worldLightRenderer = worldLightRenderer;
    }

    @Override
    public WorldLightRenderSystem createEntitySystem(WorldLightRenderSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new WorldLightRenderSystem(
                    prefab.getPriority(),
                    worldLightRenderer,
                    registry.getResource(ResourceType.WorldLightResource, WorldLight.class),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class).getCamera()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<WorldLightRenderSystemPrefab> getFactoryType() {
        return WorldLightRenderSystemPrefab.class;
    }
}
