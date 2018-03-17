package remove.tanks.game.level.engine.entity.component.speed;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class SpeedModifierComponentPrefab extends ComponentPrefab {
    private final float speedModifier;

    public SpeedModifierComponentPrefab(float speedModifier) {
        this.speedModifier = speedModifier;
    }

    public float getSpeedModifier() {
        return speedModifier;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("speedModifier", speedModifier)
                .toString();
    }
}
