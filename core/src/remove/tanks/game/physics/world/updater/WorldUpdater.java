package remove.tanks.game.physics.world.updater;

import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Mateusz Długosz
 */
public final class WorldUpdater {
    private final float timeStep;
    private final int velocityIterations;
    private final int positionIterations;

    public WorldUpdater(float timeStep, int velocityIterations, int positionIterations) {
        this.timeStep = timeStep;
        this.velocityIterations = velocityIterations;
        this.positionIterations = positionIterations;
    }

    public void update(World world) {
        step(world);
    }

    private void step(World world) {
        world.step(timeStep, velocityIterations, positionIterations);
    }
}
