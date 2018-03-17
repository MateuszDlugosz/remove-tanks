package remove.tanks.game.level.utility.spawner;

import remove.tanks.game.utility.number.counter.Counter;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerFactory {
    public Spawner createSpawner(SpawnerPrefab prefab) {
        try {
            return new Spawner(
                    prefab.getId(),
                    prefab.getEntityPrefabCodes(),
                    createCounter(prefab.getLimit()),
                    createTimer(prefab.getTime()),
                    prefab.isAutoStart()
            );
        } catch (Exception e) {
            throw new SpawnerCreateException(prefab, e);
        }
    }

    private Counter createCounter(int limit) {
        return new Counter(limit);
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }
}
