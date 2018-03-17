package remove.tanks.game.physics.light.world;

import box2dLight.RayHandler;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Mateusz Długosz
 */
public final class WorldLight extends RayHandler {
    private int numberOfRays;

    public WorldLight(World world, int numberOfRays) {
        super(world);
        this.numberOfRays = numberOfRays;
    }

    public WorldLight(World world, int fboWidth, int fboHeight, int numberOfRays) {
        super(world, fboWidth, fboHeight);
        this.numberOfRays = numberOfRays;
    }

    public int getNumberOfRays() {
        return numberOfRays;
    }
}
