package remove.tanks.game.graphic.color;

import com.badlogic.gdx.graphics.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ColorFactory {
    private final Map<Class<? extends ColorPrototype>, RegistrableColorFactory> factories
            = new HashMap<>();

    public ColorFactory(RegistrableColorFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<Color> createColors(List<ColorPrototype> prototypes) {
        return prototypes.stream()
                .map(this::createColor)
                .collect(Collectors.toList());
    }

    public Color createColor(ColorPrototype colorPrototype) {
        if (!factories.containsKey(colorPrototype.getClass())) {
            throw new ColorFactoryNotFoundException(colorPrototype.getClass().toString());
        }
        return factories.get(colorPrototype.getClass()).createColor(colorPrototype);
    }
}
