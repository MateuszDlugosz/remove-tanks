package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AnimationPrototypeXmlLoader {
    public static final String ANIMATION_ELEMENT = "animation";
    public static final String ANIMATIONS_ELEMENT = "animations";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<AnimationType, RegistrableAnimationPrototypeXmlLoader> subLoaders
            = new EnumMap<>(AnimationType.class);

    public AnimationPrototypeXmlLoader(RegistrableAnimationPrototypeXmlLoader[] subLoaders) {
        Arrays.stream(subLoaders).forEach(l -> this.subLoaders.put(l.getLoaderType(), l));
    }

    public List<AnimationPrototype> loadAnimationPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ANIMATION_ELEMENT).toArray())
                .map(this::loadAnimationPrototype)
                .collect(Collectors.toList());
    }

    public AnimationPrototype loadAnimationPrototype(XmlReader.Element element) {
        AnimationType type = AnimationType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
        if (!subLoaders.containsKey(type)) {
            throw new AnimationPrototypeLoaderNotFoundException(type);
        }
        return subLoaders.get(type).loadAnimationPrototype(element);
    }
}
