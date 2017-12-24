package remove.tanks.game.level.engine.system.spawn;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.utility.spawn.spawner.Spawner;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerFactory;
import remove.tanks.game.level.engine.utility.spawn.spawner.SpawnerPrototype;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.random.RandomNumberGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystemFactory
        implements RegistrableEntitySystemFactory<AutoSpawnerSystem, AutoSpawnerSystemPrototype>
{
    private final RandomNumberGenerator randomNumberGenerator;
    private final SpawnerFactory spawnerFactory;

    public AutoSpawnerSystemFactory(
            RandomNumberGenerator randomNumberGenerator,
            SpawnerFactory spawnerFactory
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.spawnerFactory = spawnerFactory;
    }

    @Override
    public AutoSpawnerSystem createEntitySystem(AutoSpawnerSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new AutoSpawnerSystem(
                    prototype.getPriority(),
                    randomNumberGenerator,
                    resourceRegistry.getResource(LevelResource.EntityPrototypeRepository.toString(),
                            EntityPrototypeRepository.class),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(),
                            EventBus.class),
                    createSpawnersByLetter(prototype.getSpawnerPrototypes(), false),
                    createSpawnersByLetter(prototype.getSpawnerPrototypes(), true)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    private Map<String, Spawner> createSpawnersByLetter(List<SpawnerPrototype> prototypes, boolean active) {
        return prototypes.stream()
                .filter(p -> p.isActive() == active)
                .map(spawnerFactory::createSpawner)
                .collect(Collectors.toMap(
                        Spawner::getId,
                        s -> s
                ));
    }

    @Override
    public Class<AutoSpawnerSystemPrototype> getFactoryType() {
        return AutoSpawnerSystemPrototype.class;
    }
}
