package remove.tanks.game.level.engine.system.damage;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;

/**
 * @author Mateusz Długosz
 */
public final class DamageSystemPrototype extends EntitySystemPrototype {
    private final float hitHighlightTime;

    public DamageSystemPrototype(float hitHighlightTime, int priority) {
        super(priority);
        this.hitHighlightTime = hitHighlightTime;
    }

    public float getHitHighlightTime() {
        return hitHighlightTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hitHighlightTime", hitHighlightTime)
                .toString();
    }
}
