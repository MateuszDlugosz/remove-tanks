package remove.tanks.game.level.engine.system.state.victory;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

/**
 * @author Mateusz Długosz
 */
public final class NoEnemiesVictorySystemPrefab extends EntitySystemPrefab {
    private final float delay;

    public NoEnemiesVictorySystemPrefab(int priority, float delay) {
        super(priority);
        this.delay = delay;
    }

    public float getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("delay", delay)
                .toString();
    }
}
