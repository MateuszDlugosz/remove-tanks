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
public final class ParticleImagesDirectoryAssetLoader
        extends SynchronousAssetLoader<ParticleImagesDirectory, ParticleImagesDirectoryAssetLoader.ParticleImagesDirectoryParameter>
{
    public ParticleImagesDirectoryAssetLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public ParticleImagesDirectory load(AssetManager assetManager, String fileName, FileHandle file, ParticleImagesDirectoryParameter parameter) {
        return new ParticleImagesDirectory(file);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, ParticleImagesDirectoryParameter parameter) {
        return null;
    }

    public static final class ParticleImagesDirectoryParameter extends AssetLoaderParameters<ParticleImagesDirectory> {
        public ParticleImagesDirectoryParameter() {
        }
    }
}
