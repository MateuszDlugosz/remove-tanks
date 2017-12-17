package remove.tanks.game.graphic.particle;

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
    private final Map<Class<? extends ParticleEffectPrototype>, RegistrableParticleEffectFactory> factories
            = new HashMap<>();

    public ParticleEffectFactory(RegistrableParticleEffectFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<ParticleEffect> createParticleEffects(List<ParticleEffectPrototype> prototypes, AssetStorage assetStorage, Scale scale) {
        return prototypes.stream()
                .map(p -> createParticleEffect(p, assetStorage, scale))
                .collect(Collectors.toList());
    }

    public ParticleEffect createParticleEffect(ParticleEffectPrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            if (!factories.containsKey(prototype.getClass())) {
                throw new ParticleEffectFactoryNotFoundException(prototype.getClass());
            }
            return factories.get(prototype.getClass()).createParticleEffect(prototype, assetStorage, scale);
        } catch (Exception e) {
            throw new ParticleEffectCreateException(prototype, e);
        }
    }
}
