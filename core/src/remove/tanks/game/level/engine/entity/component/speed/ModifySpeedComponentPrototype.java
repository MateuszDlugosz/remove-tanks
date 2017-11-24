package remove.tanks.game.level.engine.entity.component.speed;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class ModifySpeedComponentPrototype implements ComponentPrototype {
    private final float value;

    public ModifySpeedComponentPrototype(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
