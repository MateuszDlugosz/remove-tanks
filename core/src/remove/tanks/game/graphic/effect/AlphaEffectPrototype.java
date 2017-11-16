package remove.tanks.game.graphic.effect;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class AlphaEffectPrototype implements EffectPrototype {
    private final float alphaValue;

    public AlphaEffectPrototype(float alphaValue) {
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
