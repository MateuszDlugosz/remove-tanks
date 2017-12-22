package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class FileParticleEffectFactory
        implements RegistrableParticleEffectFactory<FileParticleEffectPrototype>
{
    @Override
    public ParticleEffect createParticleEffect(FileParticleEffectPrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            ParticleEffect pe = new ParticleEffect();
            pe.load(
                    assetStorage.getAsset(prototype.getFilename(), ParticleFile.class).getFileHandle(),
                    Gdx.files.internal(prototype.getImagesDirectory())
            );
            scaleParticleEffect(pe, scale);
            flipParticleEffect(pe, prototype.isFlipX(), prototype.isFlipY());
            return pe;
        } catch (Exception e) {
            throw new ParticleEffectCreateException(prototype, e);
        }
    }

    private void scaleParticleEffect(ParticleEffect particleEffect, Scale scale) {
        particleEffect.scaleEffect(scale.scaleValue(1f));
    }

    private void flipParticleEffect(ParticleEffect particleEffect, boolean flipX, boolean flipY) {
        particleEffect.setFlip(flipX, flipY);
    }

    @Override
    public Class<FileParticleEffectPrototype> getFactoryType() {
        return FileParticleEffectPrototype.class;
    }
}
