package remove.tanks.game.level.engine.system;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemPrefabXmlReader {
    public static final String SYSTEM_ELEMENT = "system";
    public static final String SYSTEMS_ELEMENT = "systems";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<SystemType, SubEntitySystemPrefabXmlReader> readers
            = new EnumMap<>(SystemType.class);

    public EntitySystemPrefabXmlReader(SubEntitySystemPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
    }

    public List<EntitySystemPrefab> readEntitySystemPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SYSTEM_ELEMENT).toArray())
                .map(this::readEntitySystemPrefab)
                .collect(Collectors.toList());
    }

    public EntitySystemPrefab readEntitySystemPrefab(XmlReader.Element element) {
        try {
            SystemType type = SystemType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new EntitySystemReaderNotFoundException(type);
            }
            return readers.get(type).readEntitySystemPrefab(element, type.getPriority());
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }
}