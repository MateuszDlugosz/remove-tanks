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
public final class AnimationFactory {
    private final Map<Class<? extends AnimationPrototype>, RegistrableAnimationFactory> subFactories
            = new HashMap<>();

    public AnimationFactory(RegistrableAnimationFactory[] subFactories) {
        Arrays.stream(subFactories).forEach(s -> this.subFactories.put(s.getFactoryType(), s));
    }

    public List<Animation> createAnimations(List<AnimationPrototype> prototypes, AssetStorage storage, Scale scale) {
        return prototypes.stream()
                .map(p -> createAnimation(p, storage, scale))
                .collect(Collectors.toList());
    }

    public Animation createAnimation(AnimationPrototype prototype, AssetStorage storage, Scale scale) {
        Class<? extends AnimationPrototype> prototypeClass = prototype.getClass();
        if (!subFactories.containsKey(prototypeClass)) {
            throw new AnimationFactoryNotFoundException(prototypeClass.toString());
        }
        return subFactories.get(prototypeClass).createAnimation(prototype, storage, scale);
    }
}
