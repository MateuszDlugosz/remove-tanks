package remove.tanks.game.level.engine.utility.spwan.activator;

import remove.tanks.game.level.engine.utility.letter.NATOLetter;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerActivator {
    private final NATOLetter letter;
    private final Timer timer;

    public SpawnerActivator(NATOLetter letter, Timer timer) {
        this.letter = letter;
        this.timer = timer;
    }

    public NATOLetter getLetter() {
        return letter;
    }

    public Timer getTimer() {
        return timer;
    }
}
