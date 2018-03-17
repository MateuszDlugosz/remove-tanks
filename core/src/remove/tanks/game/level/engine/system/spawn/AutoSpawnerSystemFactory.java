package remove.tanks.game.level.engine.system.spawn;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.spawner.Spawner;
import remove.tanks.game.level.utility.spawner.SpawnerFactory;
import remove.tanks.game.level.utility.spawner.SpawnerPrefab;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystemFactory implements SubEntitySystemFactory<AutoSpawnerSystem, AutoSpawnerSystemPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;
    private final SpawnerFactory spawnerFactory;

    public AutoSpawnerSystemFactory(RandomNumberGenerator randomNumberGenerator, SpawnerFactory spawnerFactory) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.spawnerFactory = spawnerFactory;
    }

    @Override
    public AutoSpawnerSystem createEntitySystem(AutoSpawnerSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new AutoSpawnerSystem(
                    prefab.getPriority(),
                    randomNumberGenerator,
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    createActiveSpawnersMap(prefab.getSpawnerPrefabs()),
                    createInactiveSpawnersMap(prefab.getSpawnerPrefabs())
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Map<String, Spawner> createActiveSpawnersMap(List<SpawnerPrefab> prefabs) {
        return prefabs.stream()
                .filter(SpawnerPrefab::isAutoStart)
                .map(spawnerFactory::createSpawner)
                .collect(Collectors.toMap(
                        Spawner::getId,
                        s -> s
                ));
    }

    private Map<String, Spawner> createInactiveSpawnersMap(List<SpawnerPrefab> prefabs) {
        return prefabs.stream()
                .filter(p -> !p.isAutoStart())
                .map(spawnerFactory::createSpawner)
                .collect(Collectors.toMap(
                        Spawner::getId,
                        s -> s
                ));
    }

    @Override
    public Class<AutoSpawnerSystemPrefab> getFactoryType() {
        return AutoSpawnerSystemPrefab.class;
    }
}
