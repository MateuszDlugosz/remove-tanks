package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class AtlasParticleEffectFactory implements SubParticleEffectFactory<AtlasParticleEffectPrefab> {
    @Override
    public ParticleEffect createParticleEffect(AtlasParticleEffectPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            ParticleEffect pe = new ParticleEffect();
            pe.load(
                    createParticleFile(prefab, assetStorage),
                    createTextureAtlas(prefab, assetStorage)
            );
            scaleParticleEffect(pe, scale);
            flipParticleEffect(pe, prefab.isFlipX(), prefab.isFlipY());
            return pe;
        } catch (Exception e) {
            throw new ParticleEffectCreateException(prefab, e);
        }
    }

    private FileHandle createParticleFile(AtlasParticleEffectPrefab prefab, AssetStorage assetStorage) {
        return assetStorage.getAsset(prefab.getFilename(), ParticleFile.class).getFileHandle();
    }

    private TextureAtlas createTextureAtlas(AtlasParticleEffectPrefab prefab, AssetStorage assetStorage) {
        return assetStorage.getAsset(prefab.getAtlasFilename(), TextureAtlas.class);
    }

    private void scaleParticleEffect(ParticleEffect particleEffect, Scale scale) {
        particleEffect.scaleEffect(scale.scaleValue(1));
    }

    private void flipParticleEffect(ParticleEffect particleEffect, boolean flipX, boolean flipY) {
        particleEffect.setFlip(flipX, flipY);
    }

    @Override
    public Class<AtlasParticleEffectPrefab> getFactoryType() {
        return AtlasParticleEffectPrefab.class;
    }
}
