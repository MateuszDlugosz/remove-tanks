package remove.tanks.game.graphics.shader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import remove.tanks.game.asset.AssetStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramFactory {
    public List<ShaderProgram> createShaderPrograms(List<ShaderProgramPrefab> programPrefabs, AssetStorage assetStorage) {
        return programPrefabs.stream()
                .map(p -> createShaderProgram(p, assetStorage))
                .collect(Collectors.toList());
    }

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
