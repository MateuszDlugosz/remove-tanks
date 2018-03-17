package remove.tanks.game.graphics.effect;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.shader.ShaderProgramPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ShaderEffectPrefab extends EffectPrefab {
    private final ShaderProgramPrefab shaderProgramPrefab;

    public ShaderEffectPrefab(ShaderProgramPrefab shaderProgramPrefab) {
        this.shaderProgramPrefab = shaderProgramPrefab;
    }

    public ShaderProgramPrefab getShaderProgramPrefab() {
        return shaderProgramPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("shaderProgramPrefab", shaderProgramPrefab)
                .toString();
    }
}
