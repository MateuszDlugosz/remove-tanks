package remove.tanks.game.level.engine.system.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.effect.EffectPrefab;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

/**
 * @author Mateusz Długosz
 */
public final class CombatSystemPrefab extends EntitySystemPrefab {
    private final EffectPrefab hitEffectPrefab;
    private final float hitTime;

    public CombatSystemPrefab(int priority, EffectPrefab hitEffectPrefab, float hitTime) {
        super(priority);
        this.hitEffectPrefab = hitEffectPrefab;
        this.hitTime = hitTime;
    }

    public EffectPrefab getHitEffectPrefab() {
        return hitEffectPrefab;
    }

    public float getHitTime() {
        return hitTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hitEffectPrefab", hitEffectPrefab)
                .add("hitTime", hitTime)
                .toString();
    }
}
