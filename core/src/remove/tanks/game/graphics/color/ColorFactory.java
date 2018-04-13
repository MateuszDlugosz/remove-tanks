package remove.tanks.game.graphics.color;

import com.badlogic.gdx.graphics.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ColorFactory {
    private final Map<Class<? extends ColorPrefab>, SubColorFactory> factories
            = new HashMap<>();

    public ColorFactory(SubColorFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public Color createColor(ColorPrefab prefab) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new ColorFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createColor(prefab);
        } catch (Exception e) {
            throw new ColorCreateException(prefab, e);
        }
    }
}
