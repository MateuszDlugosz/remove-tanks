package remove.tanks.game.level.engine.system.world;

import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.physics.light.world.renderer.WorldLightRenderer;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightRenderSystemFactory
        implements RegistrableEntitySystemFactory<WorldLightRenderSystem, WorldLightRenderSystemPrototype>
{
    private final WorldLightRenderer worldLightRenderer;

    public WorldLightRenderSystemFactory(WorldLightRenderer worldLightRenderer) {
        this.worldLightRenderer = worldLightRenderer;
    }

    @Override
    public WorldLightRenderSystem createEntitySystem(WorldLightRenderSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new WorldLightRenderSystem(
                worldLightRenderer,
                resourceRegistry.getResource(LevelResource.WorldLight.toString(), WorldLight.class),
                resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class).getCamera(),
                prototype.getPriority()
        );
    }

    @Override
    public Class<WorldLightRenderSystemPrototype> getFactoryType() {
        return WorldLightRenderSystemPrototype.class;
    }
}
