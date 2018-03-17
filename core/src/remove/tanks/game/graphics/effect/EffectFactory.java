package remove.tanks.game.graphics.effect;

import remove.tanks.game.asset.AssetStorage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class EffectFactory {
    private final Map<Class<? extends EffectPrefab>, SubEffectFactory> factories
            = new HashMap<>();

    public EffectFactory(SubEffectFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<Effect> createEffects(List<EffectPrefab> prefabs, AssetStorage assetStorage) {
        return prefabs.stream()
                .map(p -> createEffect(p, assetStorage))
                .collect(Collectors.toList());
    }

    public Effect createEffect(EffectPrefab prefab, AssetStorage assetStorage) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new EffectFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createEffect(prefab, assetStorage);
        } catch (Exception e) {
            throw new EffectCreateException(prefab, e);
        }
    }
}
