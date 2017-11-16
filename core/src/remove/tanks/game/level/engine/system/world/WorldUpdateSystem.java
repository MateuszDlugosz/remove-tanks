package remove.tanks.game.level.engine.system.world;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.physics.world.updater.WorldUpdater;

/**
 * @author Mateusz Długosz
 */
public final class WorldUpdateSystem extends EntitySystem {
    private final World world;
    private final WorldUpdater worldUpdater;

    public WorldUpdateSystem(World world, WorldUpdater worldUpdater, int priority) {
        super(priority);
        this.world = world;
        this.worldUpdater = worldUpdater;
    }

    @Override
    public void update(float deltaTime) {
        worldUpdater.step(world);
    }
}
