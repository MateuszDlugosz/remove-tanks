package remove.tanks.game.level.engine.utility.spwan.spawner;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerPrototype implements Serializable {
    private final NATOLetter letter;
    private final boolean active;
    private final int limit;
    private final float frequency;
    private final List<String> prototypeCodes;

    public SpawnerPrototype(
            NATOLetter letter,
            boolean active,
            int limit,
            float frequency,
            List<String> prototypeCodes
    ) {
        this.letter = letter;
        this.active = active;
        this.limit = limit;
        this.frequency = frequency;
        this.prototypeCodes = prototypeCodes;
    }

    public NATOLetter getLetter() {
        return letter;
    }

    public boolean isActive() {
        return active;
    }

    public int getLimit() {
        return limit;
    }

    public float getFrequency() {
        return frequency;
    }

    public List<String> getPrototypeCodes() {
        return prototypeCodes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("letter", letter)
                .add("active", active)
                .add("limit", limit)
                .add("frequency", frequency)
                .add("prototypeCodes", prototypeCodes)
                .toString();
    }
}
