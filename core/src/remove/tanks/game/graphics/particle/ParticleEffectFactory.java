package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
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
public final class ParticleEffectFactory {
    private final Map<Class<? extends ParticleEffectPrefab>, SubParticleEffectFactory> factories
            = new HashMap<>();

    public ParticleEffectFactory(SubParticleEffectFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<ParticleEffect> createParticleEffects(List<ParticleEffectPrefab> prefabs, AssetStorage assetStorage, Scale scale) {
        return prefabs.stream()
                .map(p -> createParticleEffect(p, assetStorage, scale))
                .collect(Collectors.toList());
    }

    public ParticleEffect createParticleEffect(ParticleEffectPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new ParticleEffectFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createParticleEffect(prefab, assetStorage, scale);
        } catch (Exception e) {
            throw new ParticleEffectCreateException(prefab, e);
        }
    }
}
