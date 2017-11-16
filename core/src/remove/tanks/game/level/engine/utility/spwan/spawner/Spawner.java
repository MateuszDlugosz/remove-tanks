package remove.tanks.game.level.engine.utility.spwan.spawner;

import remove.tanks.game.level.engine.utility.letter.NATOLetter;
import remove.tanks.game.utility.counter.Counter;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Spawner {
    private final NATOLetter letter;
    private final List<String> prototypeCodes;
    private final Counter counter;
    private final Timer timer;

    public Spawner(
            NATOLetter letter,
            List<String> prototypeCodes,
            Counter counter,
            Timer timer
    ) {
        this.letter = letter;
        this.prototypeCodes = prototypeCodes;
        this.counter = counter;
        this.timer = timer;
    }

    public NATOLetter getLetter() {
        return letter;
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
