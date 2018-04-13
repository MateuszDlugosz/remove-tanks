package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EffectPrefabXmlReader {
    public static final String EFFECT_ELEMENT = "effect";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<EffectType, SubEffectPrefabXmlReader> readers
            = new EnumMap<>(EffectType.class);

    public EffectPrefabXmlReader(SubEffectPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
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
