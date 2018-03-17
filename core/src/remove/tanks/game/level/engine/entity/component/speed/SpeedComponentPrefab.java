package remove.tanks.game.level.engine.entity.component.speed;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class SpeedComponentPrefab extends ComponentPrefab {
    private final float speed;

    public SpeedComponentPrefab(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("speed", speed)
                .toString();
    }
}
