package remove.tanks.game.level.engine.system.world;

import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
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
        try {
            return new WorldLightRenderSystem(
                    prototype.getPriority(),
                    worldLightRenderer,
                    resourceRegistry.getResource(LevelResource.WorldLight.toString(), WorldLight.class),
                    resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class).getCamera()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<WorldLightRenderSystemPrototype> getFactoryType() {
        return WorldLightRenderSystemPrototype.class;
    }
}
