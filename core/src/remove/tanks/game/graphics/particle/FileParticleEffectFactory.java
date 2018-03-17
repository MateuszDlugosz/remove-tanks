package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class FileParticleEffectFactory implements SubParticleEffectFactory<FileParticleEffectPrefab> {
    @Override
    public ParticleEffect createParticleEffect(FileParticleEffectPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            ParticleEffect pe = new ParticleEffect();
            pe.load(
                    createParticleFile(prefab, assetStorage),
                    createParticleImagesDirectory(prefab, assetStorage)
            );
            scaleParticleEffect(pe, scale);
            flipParticleEffect(pe, prefab.isFlipX(), prefab.isFlipY());
            return pe;
        } catch (Exception e) {
            throw new ParticleEffectCreateException(prefab, e);
        }
    }

    private FileHandle createParticleFile(FileParticleEffectPrefab prefab, AssetStorage assetStorage) {
        return assetStorage.getAsset(prefab.getFilename(), ParticleFile.class).getFileHandle();
    }

    private FileHandle createParticleImagesDirectory(FileParticleEffectPrefab prefab, AssetStorage assetStorage) {
        return assetStorage.getAsset(prefab.getImagesDirectory(), ParticleImagesDirectory.class).getFileHandle();
    }

    private void scaleParticleEffect(ParticleEffect particleEffect, Scale scale) {
        particleEffect.scaleEffect(scale.scaleValue(1f));
    }

    private void flipParticleEffect(ParticleEffect particleEffect, boolean flipX, boolean flipY) {
        particleEffect.setFlip(flipX, flipY);
    }

    @Override
    public Class<FileParticleEffectPrefab> getFactoryType() {
        return FileParticleEffectPrefab.class;
    }
}
