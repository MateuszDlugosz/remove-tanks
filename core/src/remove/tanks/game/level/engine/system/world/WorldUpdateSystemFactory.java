package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.physics.world.updater.WorldUpdater;

/**
 * @author Mateusz Długosz
 */
public final class WorldUpdateSystemFactory implements SubEntitySystemFactory<WorldUpdateSystem, WorldUpdateSystemPrefab> {
    private final WorldUpdater worldUpdater;

    public WorldUpdateSystemFactory(WorldUpdater worldUpdater) {
        this.worldUpdater = worldUpdater;
    }

    @Override
    public WorldUpdateSystem createEntitySystem(WorldUpdateSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new WorldUpdateSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.WorldResource, World.class),
                    worldUpdater
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<WorldUpdateSystemPrefab> getFactoryType() {
        return WorldUpdateSystemPrefab.class;
    }
}
