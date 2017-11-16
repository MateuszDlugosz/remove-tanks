package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.math.MathUtils;

/**
 * @author Mateusz Długosz
 */
public final class AlphaEffectFactory implements RegistrableEffectFactory<AlphaEffect, AlphaEffectPrototype> {
    public static final float MIN_ALPHA_VALUE = 0;
    public static final float MAX_ALPHA_VALUE = 255f;

    @Override
    public AlphaEffect createEffect(AlphaEffectPrototype prototype) {
        try {
            return new AlphaEffect(prepareAlphaValue(prototype));
        } catch (Exception e) {
            throw new EffectCreateException(prototype, e);
        }
    }

    private float prepareAlphaValue(AlphaEffectPrototype prototype) {
        return MathUtils.clamp(
                prototype.getAlphaValue(),
                MIN_ALPHA_VALUE,
                MAX_ALPHA_VALUE
        ) / MAX_ALPHA_VALUE;
    }

    @Override
    public Class<AlphaEffectPrototype> getFactoryType() {
        return AlphaEffectPrototype.class;
    }
}
