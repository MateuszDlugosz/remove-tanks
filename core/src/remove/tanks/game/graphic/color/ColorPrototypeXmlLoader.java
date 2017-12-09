package remove.tanks.game.graphic.color;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ColorPrototypeXmlLoader {
    public static final String COLOR_ELEMENT = "color";
    public static final String COLORS_ELEMENT = "colors";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ColorType, RegistrableColorPrototypeXmlLoader> loaders
            = new EnumMap<>(ColorType.class);

    public ColorPrototypeXmlLoader(RegistrableColorPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(s -> this.loaders.put(s.getLoaderType(), s));
    }

    public List<ColorPrototype> loadColorPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(COLOR_ELEMENT).toArray())
                .map(this::loadColorPrototype)
                .collect(Collectors.toList());
    }

    public ColorPrototype loadColorPrototype(XmlReader.Element element) {
        ColorType type = ColorType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!loaders.containsKey(type)) {
            throw new ColorPrototypeLoaderNotFoundException(type);
        }
        return loaders.get(type).loadColorPrototype(element);
    }
}
