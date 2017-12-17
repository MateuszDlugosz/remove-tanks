package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;

/**
 * @author Mateusz Długosz
 */
public final class AtlasParticleEffectFactory
        implements RegistrableParticleEffectFactory<AtlasParticleEffectPrototype>
{
    @Override
    public ParticleEffect createParticleEffect(AtlasParticleEffectPrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            ParticleEffect pe = new ParticleEffect();
            pe.load(
                    assetStorage.getAsset(prototype.getFilename(), ParticleFile.class).getFileHandle(),
                    assetStorage.getAsset(prototype.getAtlasFilename(), TextureAtlas.class)
            );
            scaleParticleEffect(pe, scale);
            flipParticleEffect(pe, prototype.isFlipX(), prototype.isFlipY());
            return pe;
        } catch (Exception e) {
            throw new ParticleEffectCreateException(prototype, e);
        }
    }

    private void scaleParticleEffect(ParticleEffect particleEffect, Scale scale) {
        particleEffect.scaleEffect(scale.scaleValue(1));
    }

    private void flipParticleEffect(ParticleEffect particleEffect, boolean flipX, boolean flipY) {
        particleEffect.setFlip(flipX, flipY);
    }

    @Override
    public Class<AtlasParticleEffectPrototype> getFactoryType() {
        return AtlasParticleEffectPrototype.class;
    }
}
