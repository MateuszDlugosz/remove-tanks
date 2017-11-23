package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.physics.world.updater.WorldUpdater;

/**
 * @author Mateusz Długosz
 */
public final class WorldUpdateSystemFactory
        implements RegistrableEntitySystemFactory<WorldUpdateSystem, WorldUpdateSystemPrototype>
{
    private final WorldUpdater worldUpdater;

    public WorldUpdateSystemFactory(WorldUpdater worldUpdater) {
        this.worldUpdater = worldUpdater;
    }

    @Override
    public WorldUpdateSystem createEntitySystem(WorldUpdateSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new WorldUpdateSystem(
                prototype.getPriority(),
                resourceRegistry.getResource(LevelResource.World.toString(), World.class),
                worldUpdater
        );
    }

    @Override
    public Class<WorldUpdateSystemPrototype> getFactoryType() {
        return WorldUpdateSystemPrototype.class;
    }
}
