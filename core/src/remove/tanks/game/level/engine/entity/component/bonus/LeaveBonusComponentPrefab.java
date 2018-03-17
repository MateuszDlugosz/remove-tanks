package remove.tanks.game.level.engine.entity.component.bonus;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusComponentPrefab extends ComponentPrefab {
    private final float chanceModifier;

    public LeaveBonusComponentPrefab(float chanceModifier) {
        this.chanceModifier = chanceModifier;
    }

    public float getChanceModifier() {
        return chanceModifier;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("chanceModifier", chanceModifier)
                .toString();
    }
}
