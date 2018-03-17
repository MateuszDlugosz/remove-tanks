package remove.tanks.game.level.engine.entity.component.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.effect.EffectPrefab;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class HitComponentPrefab extends ComponentPrefab {
    private final EffectPrefab effectPrefab;
    private final float hitTime;

    public HitComponentPrefab(EffectPrefab effectPrefab, float hitTime) {
        this.effectPrefab = effectPrefab;
        this.hitTime = hitTime;
    }

    public EffectPrefab getEffectPrefab() {
        return effectPrefab;
    }

    public float getHitTime() {
        return hitTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("effectPrefab", effectPrefab)
                .add("hitTime", hitTime)
                .toString();
    }
}
