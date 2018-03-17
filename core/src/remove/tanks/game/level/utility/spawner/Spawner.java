package remove.tanks.game.level.utility.spawner;

import remove.tanks.game.utility.number.counter.Counter;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Spawner {
    private final String id;
    private final List<String> entityPrefabCodes;
    private final Counter counter;
    private final Timer timer;
    private final boolean autoStart;

    public Spawner(
            String id,
            List<String> entityPrefabCodes,
            Counter counter,
            Timer timer,
            boolean autoStart
    ) {
        this.id = id;
        this.entityPrefabCodes = entityPrefabCodes;
        this.counter = counter;
        this.timer = timer;
        this.autoStart = autoStart;
    }

    public String getId() {
        return id;
    }

    public List<String> getEntityPrefabCodes() {
        return entityPrefabCodes;
    }

    public Counter getCounter() {
        return counter;
    }

    public Timer getTimer() {
        return timer;
    }

    public boolean isAutoStart() {
        return autoStart;
    }
}
