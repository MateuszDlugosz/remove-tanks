package remove.tanks.game.graphics.shader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import remove.tanks.game.asset.AssetStorage;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramFactory {
    public ShaderProgram createShaderProgram(ShaderProgramPrefab prefab, AssetStorage assetStorage) {
        try {
            return new ShaderProgram(
                    createVertexShaderFile(prefab, assetStorage),
                    createFragmentShaderFile(prefab, assetStorage)
            );
        } catch (Exception e) {
            throw new ShaderProgramCreateException(prefab, e);
        }
    }

    private FileHandle createVertexShaderFile(ShaderProgramPrefab prefab, AssetStorage assetStorage) {
        return assetStorage.getAsset(prefab.getVertexShaderFilename(), VertexShaderFile.class).getFileHandle();
    }

    private FileHandle createFragmentShaderFile(ShaderProgramPrefab prefab, AssetStorage assetStorage) {
        return assetStorage.getAsset(prefab.getFragmentShaderFilename(), FragmentShaderFile.class).getFileHandle();
    }
}
