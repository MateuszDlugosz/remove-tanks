package remove.tanks.game.level.event;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EventPrototypeXmlLoader {
    private static final String EVENTS_ELEMENT = "events";
    private static final String EVENT_ELEMENT = "event";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<String, RegistrableEventPrototypeXmlLoader> loaders
            = new HashMap<>();

    public EventPrototypeXmlLoader(RegistrableEventPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(loader -> this.loaders.put(loader.getLoaderType().toString(), loader));
    }

    public EventPrototype loadEventPrototype(XmlReader.Element element) {
        String type = element.getAttribute(TYPE_ATTRIBUTE).trim();
        if (!loaders.containsKey(type)) {
            throw new EventPrototypeXmlLoaderNotFoundException(type);
        }
        try {
            return loaders.get(type).loadEventPrototype(element);
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }
}
