package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

/**
 * @author Mateusz Długosz
 */
public final class ParticleFileAssetLoader
        extends SynchronousAssetLoader<ParticleFile, ParticleFileAssetLoader.ParticleFileParameter>
{
    public ParticleFileAssetLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public ParticleFile load(AssetManager assetManager, String fileName, FileHandle file, ParticleFileParameter parameter) {
        return new ParticleFile(file);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, ParticleFileParameter parameter) {
        return null;
    }

    public static final class ParticleFileParameter extends AssetLoaderParameters<ParticleFile> {
        public ParticleFileParameter() {
        }
    }
}
