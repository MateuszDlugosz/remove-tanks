package remove.tanks.game.level.engine.system.spawn;

import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.utility.spwan.activator.SpawnerActivatorFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ChainSpawnerActivateSystemFactory
        implements RegistrableEntitySystemFactory<ChainSpawnerActivateSystem, ChainSpawnerActivateSystemPrototype>
{
    private final SpawnerActivatorFactory spawnerActivatorFactory;

    public ChainSpawnerActivateSystemFactory(SpawnerActivatorFactory spawnerActivatorFactory) {
        this.spawnerActivatorFactory = spawnerActivatorFactory;
    }

    @Override
    public ChainSpawnerActivateSystem createEntitySystem(ChainSpawnerActivateSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new ChainSpawnerActivateSystem(
                spawnerActivatorFactory.createSpawnerActivators(prototype.getSpawnerActivatorPrototypes()),
                prototype.getPriority()
        );
    }

    @Override
    public Class<ChainSpawnerActivateSystemPrototype> getFactoryType() {
        return ChainSpawnerActivateSystemPrototype.class;
    }
}
