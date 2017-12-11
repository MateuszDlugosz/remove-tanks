package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class AnimationFactory {
    private final Map<Class<? extends AnimationPrototype>, RegistrableAnimationFactory> factories
            = new HashMap<>();

    public AnimationFactory(RegistrableAnimationFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<Animation> createAnimations(List<AnimationPrototype> prototypes, AssetStorage storage, Scale scale) {
        return prototypes.stream()
                .map(p -> createAnimation(p, storage, scale))
                .collect(Collectors.toList());
    }

    public Animation createAnimation(AnimationPrototype prototype, AssetStorage storage, Scale scale) {
        try {
            Class<? extends AnimationPrototype> prototypeClass = prototype.getClass();
            if (!factories.containsKey(prototypeClass)) {
                throw new AnimationFactoryNotFoundException(prototypeClass.toString());
            }
            return factories.get(prototypeClass).createAnimation(prototype, storage, scale);
        } catch (Exception e) {
            throw new AnimationCreateException(prototype, e);
        }
    }
}
