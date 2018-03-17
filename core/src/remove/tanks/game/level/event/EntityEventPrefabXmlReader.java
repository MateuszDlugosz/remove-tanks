package remove.tanks.game.level.event;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityEventPrefabXmlReader {
    public static final String ENTITY_EVENT_ELEMENT = "entityEvent";
    public static final String ENTITY_EVENTS_ELEMENT = "entityEvents";

    private static final String TYPE_ATTRIBUTE = "type";

    private final EnumMap<EntityEventType, SubEntityEventPrefabXmlReader> readers
            = new EnumMap<>(EntityEventType.class);

    public EntityEventPrefabXmlReader(SubEntityEventPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(r -> this.readers.put(r.getReaderType(), r));
    }

    public List<EntityEventPrefab> readEntityEventPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ENTITY_EVENT_ELEMENT).toArray())
                .map(this::readEntityEventPrefab)
                .collect(Collectors.toList());
    }

    public EntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            EntityEventType type = EntityEventType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new EntityEventPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readEntityEventPrefab(element);
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }
}
