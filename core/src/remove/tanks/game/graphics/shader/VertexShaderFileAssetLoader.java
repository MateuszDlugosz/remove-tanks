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
public final class VertexShaderFileAssetLoader
        extends SynchronousAssetLoader<VertexShaderFile, VertexShaderFileAssetLoader.VertexShaderFileParameter>
{
    public VertexShaderFileAssetLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public VertexShaderFile load(AssetManager assetManager, String fileName, FileHandle file, VertexShaderFileParameter parameter) {
        return new VertexShaderFile(file);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, VertexShaderFileParameter parameter) {
        return null;
    }

    public static final class VertexShaderFileParameter extends AssetLoaderParameters<VertexShaderFile> {
        public VertexShaderFileParameter() {
        }
    }
}
