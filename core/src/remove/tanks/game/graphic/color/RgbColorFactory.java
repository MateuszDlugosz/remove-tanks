package remove.tanks.game.graphic.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author Mateusz Długosz
 */
public final class RgbColorFactory implements RegistrableColorFactory<RgbColorPrototype> {
    public static final float MIN_COLOR_VALUE = 0f;
    public static final float MAX_COLOR_VALUE = 255f;
    public static final float ALPHA_COLOR_VALUE = 1f;

    @Override
    public Color createColor(RgbColorPrototype prototype) {
        try {
            return new Color(
                    createColorValue(prototype.getR()),
                    createColorValue(prototype.getG()),
                    createColorValue(prototype.getB()),
                    ALPHA_COLOR_VALUE
            );
        } catch (Exception e) {
            throw new ColorCreateException(prototype, e);
        }
    }

    private float createColorValue(float value) {
        return MathUtils.clamp(value, MIN_COLOR_VALUE, MAX_COLOR_VALUE) / MAX_COLOR_VALUE;
    }

    @Override
    public Class<RgbColorPrototype> getFactoryType() {
        return RgbColorPrototype.class;
    }
}
