package remove.tanks.game.level.event;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EventPrefabXmlReader {
    public static final String EVENT_ELEMENT = "event";
    public static final String EVENTS_ELEMENT = "events";

    private static final String TYPE_ATTRIBUTE = "type";

    private final EnumMap<EventType, SubEventPrefabXmlReader> readers = new EnumMap<>(EventType.class);

    public EventPrefabXmlReader(SubEventPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(r -> this.readers.put(r.getReaderType(), r));
    }

    public List<EventPrefab> readEventPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(EVENT_ELEMENT).toArray())
                .map(this::readEventPrefab)
                .collect(Collectors.toList());
    }

    public EventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            EventType type = EventType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new EventPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readEventPrefab(element);
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }
}
