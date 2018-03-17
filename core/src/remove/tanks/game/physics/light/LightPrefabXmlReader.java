package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LightPrefabXmlReader {
    public static final String LIGHT_ELEMENT = "light";
    public static final String LIGHTS_ELEMENT = "lights";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<LightType, SubLightPrefabXmlReader> readers
            = new EnumMap<>(LightType.class);

    public LightPrefabXmlReader(SubLightPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
    }

    public List<LightPrefab> readLightPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(LIGHT_ELEMENT).toArray())
                .map(this::readLightPrefab)
                .collect(Collectors.toList());
    }

    public LightPrefab readLightPrefab(XmlReader.Element element) {
        try {
            LightType type = LightType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new LightPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readLightPrefab(element);
        } catch (Exception e) {
            throw new LightPrefabXmlReadException(element, e);
        }
    }
}
