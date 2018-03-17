package remove.tanks.game.graphics.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author Mateusz Długosz
 */
public final class RgbaColorFactory implements SubColorFactory<RgbaColorPrefab> {
    public static final float MIN_COLOR_VALUE = 0f;
    public static final float MAX_COLOR_VALUE = 255f;

    @Override
    public Color createColor(RgbaColorPrefab prefab) {
        try {
            return new Color(
                    createColorValue(prefab.getR()),
                    createColorValue(prefab.getG()),
                    createColorValue(prefab.getB()),
                    createColorValue(prefab.getA())
            );
        } catch (Exception e) {
            throw new ColorCreateException(prefab, e);
        }
    }

    private float createColorValue(float value) {
        return MathUtils.clamp(value, MIN_COLOR_VALUE, MAX_COLOR_VALUE) / MAX_COLOR_VALUE;
    }

    @Override
    public Class<RgbaColorPrefab> getFactoryType() {
        return RgbaColorPrefab.class;
    }
}
