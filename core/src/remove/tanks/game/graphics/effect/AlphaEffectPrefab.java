package remove.tanks.game.graphics.effect;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class AlphaEffectPrefab extends EffectPrefab {
    private final float alphaValue;

    public AlphaEffectPrefab(float alphaValue) {
        this.alphaValue = alphaValue;
    }

    public float getAlphaValue() {
        return alphaValue;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("alphaValue", alphaValue)
                .toString();
    }
}
