package remove.tanks.game.level.engine.entity.component.speed;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class SpeedComponentPrototype implements ComponentPrototype {
    private final float speed;

    public SpeedComponentPrototype(float speed) {
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
