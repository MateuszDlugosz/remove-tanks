package remove.tanks.game.graphics.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author Mateusz Długosz
 */
public final class RgbColorFactory implements SubColorFactory<RgbColorPrefab> {
    public static final float MIN_COLOR_VALUE = 0f;
    public static final float MAX_COLOR_VALUE = 255f;
    public static final float ALPHA_COLOR_VALUE = 1f;

    @Override
    public Color createColor(RgbColorPrefab prefab) {
        try {
            return new Color(
                    createColorValue(prefab.getR()),
                    createColorValue(prefab.getG()),
                    createColorValue(prefab.getB()),
                    ALPHA_COLOR_VALUE
            );
        } catch (Exception e) {
            throw new ColorCreateException(prefab, e);
        }
    }

    private float createColorValue(float value) {
        return MathUtils.clamp(value, MIN_COLOR_VALUE, MAX_COLOR_VALUE) / MAX_COLOR_VALUE;
    }

    @Override
    public Class<RgbColorPrefab> getFactoryType() {
        return RgbColorPrefab.class;
    }
}
