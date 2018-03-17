package remove.tanks.game.level.engine.entity.component.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootComponentPrefab extends ComponentPrefab {
    private final float minShootFrequency;
    private final float maxShootFrequency;

    public RandomShootComponentPrefab(float minShootFrequency, float maxShootFrequency) {
        this.minShootFrequency = minShootFrequency;
        this.maxShootFrequency = maxShootFrequency;
    }

    public float getMinShootFrequency() {
        return minShootFrequency;
    }

    public float getMaxShootFrequency() {
        return maxShootFrequency;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("minShootFrequency", minShootFrequency)
                .add("maxShootFrequency", maxShootFrequency)
                .toString();
    }
}
