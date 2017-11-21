package remove.tanks.game.level.engine.system.spawn;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;
import remove.tanks.game.level.engine.utility.spwan.spawner.Spawner;
import remove.tanks.game.level.engine.utility.spwan.spawner.SpawnerFactory;
import remove.tanks.game.level.engine.utility.spwan.spawner.SpawnerPrototype;
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
        return new AutoSpawnerSystem(
                randomNumberGenerator,
                resourceRegistry.getResource(LevelResource.EntityPrototypeRepository.toString(),
                        EntityPrototypeRepository.class),
                resourceRegistry.getResource(LevelResource.EventBus.toString(),
                        EventBus.class),
                createSpawnersByLetter(prototype.getSpawnerPrototypes(), false),
                createSpawnersByLetter(prototype.getSpawnerPrototypes(), true),
                prototype.getPriority()
        );
    }

    private Map<NATOLetter, Spawner> createSpawnersByLetter(List<SpawnerPrototype> prototypes, boolean active) {
        return prototypes.stream()
                .filter(p -> p.isActive() == active)
                .map(spawnerFactory::createSpawner)
                .collect(Collectors.toMap(
                        Spawner::getLetter,
                        s -> s
                ));
    }

    @Override
    public Class<AutoSpawnerSystemPrototype> getFactoryType() {
        return AutoSpawnerSystemPrototype.class;
    }
}
