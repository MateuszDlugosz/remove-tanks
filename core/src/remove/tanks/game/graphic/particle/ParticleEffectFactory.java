package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.asset.AssetStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectFactory {
    public List<ParticleEffect> createParticleEffects(List<ParticleEffectPrototype> prototypes, AssetStorage assetStorage) {
        return prototypes.stream()
                .map(p -> createParticleEffect(p, assetStorage))
                .collect(Collectors.toList());
    }

    public ParticleEffect createParticleEffect(ParticleEffectPrototype prototype, AssetStorage assetStorage) {
       try {
           ParticleEffect pe = assetStorage.getAsset(prototype.getFilename(), ParticleEffect.class);
           pe.setFlip(prototype.isFlipX(), prototype.isFlipY());
           return pe;
       } catch (Exception e) {
           throw new ParticleEffectCreateException(prototype, e);
       }
    }
}
