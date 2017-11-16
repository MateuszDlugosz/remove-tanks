package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.physics.world.renderer.WorldRenderer;

/**
 * @author Mateusz Długosz
 */
public final class WorldDebugRenderSystemFactory
    implements RegistrableEntitySystemFactory<WorldDebugRenderSystem, WorldDebugRenderSystemPrototype>
{
    private final WorldRenderer worldRenderer;

    public WorldDebugRenderSystemFactory(WorldRenderer worldRenderer) {
        this.worldRenderer = worldRenderer;
    }

    @Override
    public WorldDebugRenderSystem createEntitySystem(WorldDebugRenderSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new WorldDebugRenderSystem(
                worldRenderer,
                resourceRegistry.getResource(LevelResource.World.toString(), World.class),
                resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class).getCamera(),
                prototype.getPriority()
        );
    }

    @Override
    public Class<WorldDebugRenderSystemPrototype> getFactoryType() {
        return WorldDebugRenderSystemPrototype.class;
    }
}
