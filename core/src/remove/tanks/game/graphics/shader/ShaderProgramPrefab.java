package remove.tanks.game.graphics.shader;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramPrefab extends Prefab {
    private final String vertexShaderFilename;
    private final String fragmentShaderFilename;

    public ShaderProgramPrefab(String vertexShaderFilename, String fragmentShaderFilename) {
        this.vertexShaderFilename = vertexShaderFilename;
        this.fragmentShaderFilename = fragmentShaderFilename;
    }

    public String getVertexShaderFilename() {
        return vertexShaderFilename;
    }

    public String getFragmentShaderFilename() {
        return fragmentShaderFilename;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("vertexShaderFilename", vertexShaderFilename)
                .add("fragmentShaderFilename", fragmentShaderFilename)
                .toString();
    }
}
