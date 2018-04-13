package remove.tanks.game.graphics.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class AnimationFactory {
    private final Map<Class<? extends AnimationPrefab>, SubAnimationFactory> factories
            = new HashMap<>();

    public AnimationFactory(SubAnimationFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public Animation createAnimation(AnimationPrefab prefab, AssetStorage storage, Scale scale) {
        try {
            Class<? extends AnimationPrefab> prefabClass = prefab.getClass();
            if (!factories.containsKey(prefabClass)) {
                throw new AnimationFactoryNotFoundException(prefabClass);
            }
            return factories.get(prefabClass).createAnimation(prefab, storage, scale);
        } catch (Exception e) {
            throw new AnimationCreateException(prefab, e);
        }
    }
}
