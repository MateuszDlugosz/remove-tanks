package remove.tanks.game.graphic.effect;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.color.ColorPrototype;

/**
 * @author Mateusz Długosz
 */
public final class TintEffectPrototype implements EffectPrototype {
    private final ColorPrototype colorPrototype;

    public TintEffectPrototype(ColorPrototype colorPrototype) {
        this.colorPrototype = colorPrototype;
    }

    public ColorPrototype getColorPrototype() {
        return colorPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("colorPrototype", colorPrototype)
                .toString();
    }
}
