package remove.tanks.game.physics.light.world;

import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightFactory {
    private final int numberOfRays;

    public WorldLightFactory(int numberOfRays) {
        this.numberOfRays = numberOfRays;
    }

    public WorldLight createWorldLight(World world) {
        try {
            return new WorldLight(world, numberOfRays);
        } catch (Exception e) {
            throw new WorldLightCreateException(e);
        }
    }
}
