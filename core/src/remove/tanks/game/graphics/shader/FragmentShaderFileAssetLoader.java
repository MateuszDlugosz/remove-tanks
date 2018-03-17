package remove.tanks.game.graphics.shader;

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
public final class FragmentShaderFileAssetLoader
        extends SynchronousAssetLoader<FragmentShaderFile, FragmentShaderFileAssetLoader.FragmentShaderFileParameter>
{
    public FragmentShaderFileAssetLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public FragmentShaderFile load(AssetManager assetManager, String fileName, FileHandle file, FragmentShaderFileParameter parameter) {
        return new FragmentShaderFile(file);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, FragmentShaderFileParameter parameter) {
        return null;
    }

    public static final class FragmentShaderFileParameter extends AssetLoaderParameters<FragmentShaderFile> {
        public FragmentShaderFileParameter() {
        }
    }
}
