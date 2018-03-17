package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EffectPrefabXmlReader {
    public static final String EFFECT_ELEMENT = "effect";
    public static final String EFFECTS_ELEMENT = "effects";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<EffectType, SubEffectPrefabXmlReader> readers
            = new EnumMap<>(EffectType.class);

    public EffectPrefabXmlReader(SubEffectPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
    }

    public List<EffectPrefab> readEffectPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(EFFECT_ELEMENT).toArray())
                .map(this::readEffectPrefab)
                .collect(Collectors.toList());
    }

    public EffectPrefab readEffectPrefab(XmlReader.Element element) {
        try {
            EffectType type = EffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new EffectPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readEffectPrefab(element);
        } catch (Exception e) {
            throw new EffectPrefabXmlReadException(element, e);
        }
    }
}
