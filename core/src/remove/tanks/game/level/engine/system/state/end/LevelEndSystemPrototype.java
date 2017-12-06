package remove.tanks.game.level.engine.system.state.end;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;

/**
 * @author Mateusz Długosz
 */
public final class LevelEndSystemPrototype extends EntitySystemPrototype {
    private final float endTime;

    public LevelEndSystemPrototype(int priority, float endTime) {
        super(priority);
        this.endTime = endTime;
    }

    public float getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("endTime", endTime)
                .toString();
    }
}
