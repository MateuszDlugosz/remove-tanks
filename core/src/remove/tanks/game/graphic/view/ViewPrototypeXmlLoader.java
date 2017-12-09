package remove.tanks.game.graphic.view;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ViewPrototypeXmlLoader {
    public static final String VIEW_ELEMENT = "view";
    public static final String VIEWS_ELEMENT = "views";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ViewType, RegistrableViewPrototypeXmlLoader> loaders
            = new EnumMap<>(ViewType.class);

    public ViewPrototypeXmlLoader(RegistrableViewPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(s -> this.loaders.put(s.getLoaderType(), s));
    }

    public List<ViewPrototype> loadViewPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(VIEW_ELEMENT).toArray())
                .map(this::loadViewPrototype)
                .collect(Collectors.toList());
    }

    public ViewPrototype loadViewPrototype(XmlReader.Element element) {
        ViewType type = ViewType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!loaders.containsKey(type)) {
            throw new ViewPrototypeLoaderNotFoundException(type);
        }
        return loaders.get(type).loadViewPrototype(element);
    }
}
