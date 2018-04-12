package remove.tanks.game.graphics.animation;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AnimationPrefabXmlReader {
    public static final String ANIMATION_ELEMENT = "animation";
    public static final String ANIMATIONS_ELEMENT = "animations";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<AnimationType, SubAnimationPrefabXmlReader> readers
            = new EnumMap<>(AnimationType.class);

    public AnimationPrefabXmlReader(SubAnimationPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(l -> this.readers.put(l.getReaderType(), l));
    }

    public AnimationPrefab readAnimationPrefab(XmlReader.Element element) {
        try {
            AnimationType type = AnimationType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new AnimationReaderNotFoundException(type);
            }
            return readers.get(type).readAnimationPrefab(element);
        } catch (Exception e) {
            throw new AnimationPrefabXmlReadException(element, e);
        }
    }
}
