package remove.tanks.game.graphic.effect;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.shader.ShaderProgramPrototype;

/**
 * @author Mateusz Długosz
 */
public final class ShaderEffectPrototype implements EffectPrototype {
    private final ShaderProgramPrototype shaderProgramPrototype;

    public ShaderEffectPrototype(ShaderProgramPrototype shaderProgramPrototype) {
        this.shaderProgramPrototype = shaderProgramPrototype;
    }

    public ShaderProgramPrototype getShaderProgramPrototype() {
        return shaderProgramPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("shaderProgramPrototype", shaderProgramPrototype)
                .toString();
    }
}
