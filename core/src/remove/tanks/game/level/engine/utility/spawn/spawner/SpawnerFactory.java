package remove.tanks.game.level.engine.utility.spawn.spawner;

import remove.tanks.game.utility.counter.Counter;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerFactory {
    public Spawner createSpawner(SpawnerPrototype prototype) {
        try {
            return new Spawner(
                    prototype.getId(),
                    prototype.getPrototypeCodes(),
                    createCounter(prototype.getLimit()),
                    createTimer(prototype.getFrequency())
            );
        } catch (Exception e) {
            throw new SpawnerCreateException(prototype, e);
        }
    }

    private Counter createCounter(int limit) {
        return new Counter(limit);
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }
}
