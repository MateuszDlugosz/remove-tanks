package remove.tanks.game.level.engine.entity.component;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ComponentPrefabXmlReader {
    public static final String COMPONENT_ELEMENT = "component";
    public static final String COMPONENTS_ELEMENT = "components";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ComponentType, SubComponentPrefabXmlReader> readers
            = new EnumMap<>(ComponentType.class);

    public ComponentPrefabXmlReader(SubComponentPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
    }

    public List<ComponentPrefab> readComponentsPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(COMPONENT_ELEMENT).toArray())
                .map(this::readComponentPrefab)
                .collect(Collectors.toList());
    }

    public ComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            ComponentType type = ComponentType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new ComponentPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readComponentPrefab(element);
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }
}
