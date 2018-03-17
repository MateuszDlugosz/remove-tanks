package remove.tanks.game.level.engine.listener;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityListenerPrefabXmlReader {
    public static final String LISTENER_ELEMENT = "listener";
    public static final String LISTENERS_ELEMENT = "listeners";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ListenerType, SubEntityListenerPrefabXmlReader> readers
            = new EnumMap<>(ListenerType.class);

    public EntityListenerPrefabXmlReader(SubEntityListenerPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(l -> this.readers.put(l.getReaderType(), l));
    }

    public List<EntityListenerPrefab> readEntityListenersPrefabs(XmlReader.Element elements) {
        return Arrays.stream(elements.getChildrenByName(LISTENER_ELEMENT).toArray())
                .map(this::readEntityListenerPrefab)
                .collect(Collectors.toList());
    }

    public EntityListenerPrefab readEntityListenerPrefab(XmlReader.Element element) {
        try {
            ListenerType type = ListenerType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new EntityListenerReaderNotFoundException(type);
            }
            return readers.get(type).readEntityListenerPrefab(element, type.getPriority());
        } catch (Exception e) {
            throw new EntityListenerPrefabXmlReadException(element, e);
        }
    }
}
