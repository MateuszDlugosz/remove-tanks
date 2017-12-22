package remove.tanks.game.level.engine.system.hud.stages.widget;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class WidgetPrototypeXmlLoader {
    public static final String WIDGET_ELEMENT = "widget";
    public static final String WIDGETS_ELEMENT = "widgets";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<WidgetType, RegistrableWidgetPrototypeXmlLoader> loaders
            = new HashMap<>();

    public WidgetPrototypeXmlLoader(RegistrableWidgetPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(l -> this.loaders.put(l.getLoaderType(), l));
    }

    public List<WidgetPrototype> loadWidgetPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(WIDGET_ELEMENT).toArray())
                .map(this::loadWidgetPrototype)
                .collect(Collectors.toList());
    }

    public WidgetPrototype loadWidgetPrototype(XmlReader.Element element) {
        try {
            WidgetType type = WidgetType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!loaders.containsKey(type)) {
                throw new WidgetPrototypeLoaderNotFoundException(type);
            }
            return loaders.get(type).loadWidgetPrototype(element);
        } catch (Exception e) {
            throw new WidgetPrototypeXmlLoadException(element, e);
        }
    }
}
