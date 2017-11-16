package remove.tanks.game.level.engine.utility.spwan.activator;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerActivatorPrototype implements Serializable {
    private final NATOLetter letter;
    private final float delay;

    public SpawnerActivatorPrototype(NATOLetter letter, float delay) {
        this.letter = letter;
        this.delay = delay;
    }

    public NATOLetter getLetter() {
        return letter;
    }

    public float getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("letter", letter)
                .add("delay", delay)
                .toString();
    }
}
