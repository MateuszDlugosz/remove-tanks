package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.graphics.Color;
import remove.tanks.game.graphic.color.ColorFactory;

/**
 * @author Mateusz Długosz
 */
public final class TintEffectFactory implements RegistrableEffectFactory<TintEffect, TintEffectPrototype> {
    private final ColorFactory colorFactory;

    public TintEffectFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public TintEffect createEffect(TintEffectPrototype prototype) {
        try {
            return new TintEffect(createColor(prototype));
        } catch (Exception e) {
            throw new EffectCreateException(prototype, e);
        }
    }

    private Color createColor(TintEffectPrototype prototype) {
        return colorFactory.createColor(prototype.getColorPrototype());
    }

    @Override
    public Class<TintEffectPrototype> getFactoryType() {
        return TintEffectPrototype.class;
    }
}
