package remove.tanks.game.level.engine.utility.spwan.activator;

import remove.tanks.game.utility.time.Timer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerActivatorFactory {
    public List<SpawnerActivator> createSpawnerActivators(List<SpawnerActivatorPrototype> prototypes) {
        return prototypes.stream()
                .map(this::createSpawnerActivator)
                .collect(Collectors.toList());
    }

    public SpawnerActivator createSpawnerActivator(SpawnerActivatorPrototype prototype) {
        try {
            return new SpawnerActivator(prototype.getLetter(), new Timer(prototype.getDelay()));
        } catch (Exception e) {
            throw new SpawnActivatorCreateException(prototype, e);
        }
    }
}
