package remove.tanks.game.level.engine.utility.spwan.spawner;

import remove.tanks.game.utility.counter.Counter;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Spawner {
    private final String id;
    private final List<String> prototypeCodes;
    private final Counter counter;
    private final Timer timer;

    public Spawner(
            String id,
            List<String> prototypeCodes,
            Counter counter,
            Timer timer
    ) {
        this.id = id;
        this.prototypeCodes = prototypeCodes;
        this.counter = counter;
        this.timer = timer;
    }

    public String getId() {
        return id;
    }

    public List<String> getPrototypeCodes() {
        return prototypeCodes;
    }

    public Counter getCounter() {
        return counter;
    }

    public Timer getTimer() {
        return timer;
    }
}
