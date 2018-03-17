package remove.tanks.game.physics.world.renderer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Mateusz Długosz
 */
public final class WorldRenderer {
    private final Box2DDebugRenderer box2DDebugRenderer;

    public WorldRenderer(Box2DDebugRenderer box2DDebugRenderer) {
        this.box2DDebugRenderer = box2DDebugRenderer;
    }

    public void render(World world, Camera camera) {
        box2DDebugRenderer.render(world, camera.combined);
    }
}
