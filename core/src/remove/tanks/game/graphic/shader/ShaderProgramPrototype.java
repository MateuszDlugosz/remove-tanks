package remove.tanks.game.graphic.shader;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class ShaderProgramPrototype implements Serializable {
    private final String vertexShaderFilename;
    private final String fragmentShaderFilename;

    public ShaderProgramPrototype(String vertexShaderFilename, String fragmentShaderFilename) {
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
