package remove.tanks.game.level.engine.system.world;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.physics.world.renderer.WorldRenderer;

/**
 * @author Mateusz Długosz
 */
public final class WorldDebugRenderSystem extends EntitySystem {
    private final WorldRenderer worldRenderer;
    private final World world;
    private final OrthographicCamera camera;

    public WorldDebugRenderSystem(
            WorldRenderer worldRenderer,
            World world,
            OrthographicCamera camera,
            int priority
    ) {
        super(priority);
        this.worldRenderer = worldRenderer;
        this.world = world;
        this.camera = camera;
    }

    @Override
    public void update(float deltaTime) {
        worldRenderer.render(world, camera);
    }
}
