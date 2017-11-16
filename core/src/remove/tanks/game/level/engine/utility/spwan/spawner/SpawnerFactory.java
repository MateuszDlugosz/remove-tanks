package remove.tanks.game.level.engine.utility.spwan.spawner;

import remove.tanks.game.utility.counter.Counter;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerFactory {
    public Spawner createSpawner(SpawnerPrototype prototype) {
        try {
            return new Spawner(
                    prototype.getLetter(),
                    prototype.getPrototypeCodes(),
                    new Counter(prototype.getLimit()),
                    new Timer(prototype.getFrequency())
            );
        } catch (Exception e) {
            throw new SpawnerCreateException(prototype, e);
        }
    }
}
