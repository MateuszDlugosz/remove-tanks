package remove.tanks.game.level.engine.listener;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerPrototypeXmlLoader {
    public static final String LISTENER_ELEMENT = "listener";
    public static final String LISTENERS_ELEMENT = "listeners";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ListenerType, RegistrableEntityListenerPrototypeXmlLoader> subLoaders
            = new EnumMap<>(ListenerType.class);

    public EntityListenerPrototypeXmlLoader(RegistrableEntityListenerPrototypeXmlLoader[] subLoaders) {
        Arrays.stream(subLoaders).forEach(l -> this.subLoaders.put(l.getLoaderType(), l));
    }

    public List<EntityListenerPrototype> loadEntityListenersPrototypes(Array<XmlReader.Element> elements) {
        return Arrays.stream(elements.toArray())
                .map(this::loadEntityListenerPrototype)
                .collect(Collectors.toList());
    }

    public EntityListenerPrototype loadEntityListenerPrototype(XmlReader.Element element) {
        ListenerType type = ListenerType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!subLoaders.containsKey(type)) {
            throw new EntityListenerLoaderNotFoundException(type);
        }
        try {
            return subLoaders.get(type).loadEntityListenerPrototype(element);
        } catch (Exception e) {
            throw new EntityListenerPrototypeXmlLoadException(element, e);
        }
    }
}
